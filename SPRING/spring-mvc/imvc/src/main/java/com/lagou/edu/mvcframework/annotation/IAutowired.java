package com.lagou.edu.mvcframework.annotation;

import java.lang.annotation.*;

@Documented
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface IAutowired {

	String value() default "";

}
