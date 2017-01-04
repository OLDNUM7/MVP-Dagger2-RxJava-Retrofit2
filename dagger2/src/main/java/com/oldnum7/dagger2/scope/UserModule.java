package com.oldnum7.dagger2.scope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Administrator on 2017/1/4.
 */
@Module
public class UserModule {
    private User user;
    private User userA;
    private User userB;

    public UserModule(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User privideUser() {
        return user;
    }

    public UserModule(User userA, User userB) {
        this.userB = userB;
        this.userA = userA;
    }

    @UserNamed("a")
    @Provides
    @UserScope
    User provideUserA() {
        return userA;
    }

    @UserNamed("b")
    @Provides
    @UserScope
    User provideUserB() {
        return userB;
    }
}
