package com.oldnum7.mvpdagger2rxjavaretrofit2.base2;

/**
 * Created by tangyangkai on 16/5/10.
 */
public class MainActivity extends AppActivity {

    @Override
    protected BaseFragment getFirstFragment() {
        return MainFragment.newInstance();
    }
}
