package com.oldnum7.dagger2.scope.a;

import dagger.Subcomponent;

/**
 * Created by wanglj on 16/6/22.
 */
@Subcomponent(modules = AModule.class)
public interface AComponent {
    void inject(AActivity aActivity);
}
