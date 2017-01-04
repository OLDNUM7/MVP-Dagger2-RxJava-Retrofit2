package com.oldnum7.dagger2.scope;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by Administrator on 2017/1/4.
 */
@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface UserScope {

}
