package com.frameworkanntations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD})
public @interface FrameWorkAnnotations {
    String[] authors() default "default user";
    String[] catgeories() default "default category";
}
