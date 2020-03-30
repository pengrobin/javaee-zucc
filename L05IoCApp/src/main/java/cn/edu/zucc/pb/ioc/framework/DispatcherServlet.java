package cn.edu.zucc.pb.ioc.framework;

import cn.edu.zucc.pb.ioc.service.ILogin;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;

/**
 * TODO 如果能把这个通过配置文件的版本改为使用Java Annotation的版本，那么就是高手了
 * @author pengbin
 * @version 1.0
 * @date 2020-03-21 15:45
 */
public class DispatcherServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //Load config file
        PbIocContext context = PbIocContext.getInstance();

        String url = request.getRequestURI();
        //是非常简单的实现，仅用于演示IoC,假设只处理Login,这里也没有任何合法性检查
        //TODO 扩展配置文件，可以支持不同的URL绑定到不同的Service，而不是这里仅仅支持login
        String[] pathTokens = url.split("/");
        if("login".equals(pathTokens[pathTokens.length - 1])){
            try {
                ControllerNode controllerNode = context.getIocMapping().getController();
                Object controller = Class.forName(controllerNode.getClazz()).newInstance();

                ServiceNode serviceNode = context.getIocMapping().findService(controllerNode.getRef());
                Object service = Class.forName(serviceNode.getClazz()).newInstance();
                //TODO 改造这种固定了ILogin服务参数的做法，支持使用set方法绑定具体的服务类
                Object ret = controller.getClass()
                        .getMethod("doPost", ILogin.class, HttpServletRequest.class, HttpServletResponse.class)
                        .invoke(controller, service, request, response);

                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("text/plain");
                PrintWriter out = response.getWriter();
                out.println(ret.toString());
                return;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            }

            response.setStatus(HttpServletResponse.SC_SERVICE_UNAVAILABLE);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        return;
    }
}
