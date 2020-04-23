package cn.edu.zucc.pb.ja;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author pengbin
 * @version 1.0
 * @date 2020-04-23 11:17
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EntityLog {
    String value() default "";
}
