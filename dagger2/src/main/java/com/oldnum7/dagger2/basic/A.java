package com.oldnum7.dagger2.basic;

import android.util.Log;

import javax.inject.Inject;

/**
 * Created by Administrator on 2017/1/3.
 */

public class A {
    public String field;

    @Inject
    public A() {
    }

    public void doString() {
        Log.e("A", "do something");
    }
}
