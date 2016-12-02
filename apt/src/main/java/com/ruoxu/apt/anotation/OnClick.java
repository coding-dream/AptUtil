package com.ruoxu.apt.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Target(ElementType.TYPE)
@Retention(RetentionPolicy.CLASS)
public @interface OnClick {
    String name() default "xiaoming";
    String value() default "123";
}
