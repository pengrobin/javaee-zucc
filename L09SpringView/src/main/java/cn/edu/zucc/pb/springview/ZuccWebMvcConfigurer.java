package cn.edu.zucc.pb.springview;

import cn.edu.zucc.pb.springview.interception.TokenCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-05-02 20:44
 */
@Configuration
public class ZuccWebMvcConfigurer implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        System.out.println("TokenCheckInterceptor added");
        registry.addInterceptor(new TokenCheckInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/login");
    }
}

