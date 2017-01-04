package com.oldnum7.dagger2.basic;

import com.google.gson.Gson;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/3.
 */

@Module
public class GsonModule {

    @Provides
    public Gson provideGson() {
        return new Gson();
    }
}
