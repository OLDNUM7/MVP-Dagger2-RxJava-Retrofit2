package com.oldnum7.dagger2.basic;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/4.
 */

@Module
public class BModule {

    @Provides
    public B provideA() {
        return new B();
    }
}
