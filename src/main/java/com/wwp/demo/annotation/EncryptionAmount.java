package com.wwp.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: 金额加密自定义注解
 * @Author: wwp
 * @Date: 2019-10-31
**/
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface EncryptionAmount {
//    String key() default "";
}
