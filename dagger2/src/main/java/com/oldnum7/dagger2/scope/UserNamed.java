package com.oldnum7.dagger2.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by Administrator on 2017/1/4.
 */

@Qualifier
@Retention(RetentionPolicy.RUNTIME)
public @interface UserNamed {
    String value() default "";
}
