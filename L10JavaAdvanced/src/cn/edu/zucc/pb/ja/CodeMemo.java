package cn.edu.zucc.pb.ja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-22 22:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CodeMemo {
    String name() default "unkown";
    String date() default "";
    String intro() default "";
}
