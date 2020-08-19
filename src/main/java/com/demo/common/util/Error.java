package com.demo.common.util;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)  
public @interface  Error {
    String msg() default "";  
    int code() default 0;
}  
