package com.oldnum7.dagger2.basic;

import com.oldnum7.dagger2.MainActivity;

import dagger.Component;

/**
 * Created by Administrator on 2017/1/3.
 */

//component首先先去提供的module里面寻找提供的实例，没有找到时再去找构造函数@inject注解
@Component(modules = {GsonModule.class,BModule.class})
public interface GsonComponent {
    void inject(MainActivity mainActivity);
}
