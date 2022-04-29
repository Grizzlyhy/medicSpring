package com.zhou.code.encrypt.annotation;

import java.lang.annotation.*;

/**
 * 解密注解
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface Encrypt {

    String value() default "";
}
