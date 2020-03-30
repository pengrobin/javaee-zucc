import cn.edu.zucc.pb.cgproxy.CglibProxy;
import cn.edu.zucc.pb.dynamicproxy.DynamicServiceProxy;
import cn.edu.zucc.pb.dynamicproxy.IService;
import cn.edu.zucc.pb.staticproxy.ServiceImpl;
import cn.edu.zucc.pb.staticproxy.ServiceProxy;

import java.lang.reflect.Proxy;

public class Main {

    public static void main(String[] args) {
        //注意：如果结合前面一讲的IoC，这里的Proxy对象，ServiceImpl对象都是可以动态创建和注入的
        ServiceProxy proxy = new ServiceProxy(new ServiceImpl());
        proxy.doA();
        proxy.doB();

        //动态代理
        IService svc = (IService)Proxy.newProxyInstance(
                IService.class.getClassLoader(),
                new Class[]{IService.class},
                new DynamicServiceProxy(new cn.edu.zucc.pb.dynamicproxy.ServiceImpl()));
        svc.doA();
        svc.doB();

        //CGLib动态代理
        cn.edu.zucc.pb.cgproxy.IService cgSvc = new cn.edu.zucc.pb.cgproxy.ServiceImpl();
        CglibProxy cglibProxy = new CglibProxy();
        cn.edu.zucc.pb.cgproxy.ServiceImpl svcImplProxy =
                (cn.edu.zucc.pb.cgproxy.ServiceImpl)cglibProxy.getInstance(cgSvc);
        svcImplProxy.doA();
        svcImplProxy.doB();
    }
}
