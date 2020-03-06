package cn.edu.zucc.pb.servletbasic;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * 使用POST
 * POST url
 * request body : name=admin&password=123456
 * @author pengbin
 * @version 1.0
 * @date 2020-03-06 11:28
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/login"}, loadOnStartup = 1)
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        if("admin".equalsIgnoreCase(name)
                && "123456".equalsIgnoreCase(password)){
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("text/plain");
            PrintWriter out = response.getWriter();
            out.println("login successful.");
        } else  {
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        }
    }

}
