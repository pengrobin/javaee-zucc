package cn.edu.zucc.pb.springview.interception;

import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-05-02 20:37
 */
public class TokenCheckInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("token check......");
        String token = request.getHeader("token");
        if(!validate(token)){
            response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
            return false;
        }
        
        return true;
    }

    private boolean validate(String token) {
        return "poweroverwhelming".equals(token);
    }
}
