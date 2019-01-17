package com.sakura.ofm.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//作用域
@Target({ElementType.METHOD,ElementType.TYPE})
//生命周期
@Retention(RetentionPolicy.RUNTIME)
public @interface OFM {

    public String isCheck() default "yes";
}
