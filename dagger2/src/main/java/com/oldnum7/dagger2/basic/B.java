 package com.oldnum7.dagger2.basic;

import android.util.Log;

/**
 * Created by Administrator on 2017/1/4.
 */

public class B {
    public String field;

    public B() {
    }

    @Override
    public String toString() {
        return "这是一个B类";
    }
    public void doSomething(){
        Log.e("B", "doSomething B");
    }
}
