package com.zyd.blog.business.annotation;

import com.zyd.blog.business.enums.LimitTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Limit {
    String name() default "";

    String key() default "";

    String prefix() default "";

    int preiod();

    int count();

    LimitTypeEnum limitType() default LimitTypeEnum.CUSTOM;
}