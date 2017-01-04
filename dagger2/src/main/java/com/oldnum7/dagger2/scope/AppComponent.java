package com.oldnum7.dagger2.scope;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/4.
 */

@Singleton
@Component(modules = AppModule.class)
public interface AppComponent {
    UserComponent plus(UserModule userModule);
}
