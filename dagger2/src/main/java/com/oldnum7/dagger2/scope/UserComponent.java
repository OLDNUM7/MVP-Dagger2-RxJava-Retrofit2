package com.oldnum7.dagger2.scope;

import com.oldnum7.dagger2.scope.a.AComponent;
import com.oldnum7.dagger2.scope.a.AModule;
import com.oldnum7.dagger2.scope.b.BComponent;
import com.oldnum7.dagger2.scope.b.BModule;
import com.oldnum7.dagger2.scope.c.CComponent;
import com.oldnum7.dagger2.scope.c.CModule;

import dagger.Subcomponent;

/**
 * Created by Administrator on 2017/1/4.
 */

@UserScope
@Subcomponent(modules = UserModule.class)
public interface UserComponent {

    AComponent plus(AModule aModule);
    BComponent plus(BModule bModule);
    CComponent plus(CModule cModule);

}
