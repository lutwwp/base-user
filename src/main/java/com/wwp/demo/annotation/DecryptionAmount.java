package com.wwp.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description: TODO
 * @Author: wwp
 * @Date: 2019-10-31
**/
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface DecryptionAmount {
}
