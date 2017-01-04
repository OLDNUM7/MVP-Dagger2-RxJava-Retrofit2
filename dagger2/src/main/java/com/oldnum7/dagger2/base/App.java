package com.oldnum7.dagger2.base;

import android.app.Application;
import android.content.Context;

import com.oldnum7.dagger2.scope.AppComponent;
import com.oldnum7.dagger2.scope.AppModule;
import com.oldnum7.dagger2.scope.DaggerAppComponent;
import com.oldnum7.dagger2.scope.User;
import com.oldnum7.dagger2.scope.UserComponent;
import com.oldnum7.dagger2.scope.UserModule;

/**
 * Created by Administrator on 2017/1/4.
 */

public class App extends Application {

    //appliction组件
    private AppComponent appComponent;

    //用户组件

    private UserComponent userComponent;

    public static App get(Context context) {
        return (App) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //注入全局Application
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    //对外提供UserComponent
    public UserComponent getUserComponent() {
        return userComponent;
    }

    //注入UserComponent，调用此方法后，UserCope生效
    public UserComponent createUserComponent(User user) {
        userComponent = appComponent.plus(new UserModule(user));
        return userComponent;
    }

    public UserComponent createUserComponent(User userA, User userB) {
        userComponent = appComponent.plus(new UserModule(userA, userB));
        return userComponent;
    }

    //释放UserComponent组件
    public void releaseUserComponent() {
        userComponent = null;
    }

}
