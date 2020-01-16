package com.lagou.edu.mvcframework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface IServeice {

	String value() default "";

}
