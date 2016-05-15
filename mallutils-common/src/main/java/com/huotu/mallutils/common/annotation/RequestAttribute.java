package com.huotu.mallutils.common.annotation;

import java.lang.annotation.*;

/**
 * Created by allan on 5/16/16.
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface RequestAttribute {
    String value() default "";
}
