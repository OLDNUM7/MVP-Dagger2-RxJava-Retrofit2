package com.oldnum7.mvpdagger2rxjavaretrofit2.view;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.oldnum7.mvpdagger2rxjavaretrofit2.R;
import com.oldnum7.mvpdagger2rxjavaretrofit2.presenter.MvpPresenter;

import butterknife.ButterKnife;

/**
 * Created by admin on 2017/1/10.
 */

public class MvpActivity extends BaseMvpActivity<MvpView,MvpPresenter> implements MvpView{

    @Bind(R.id.tvShow)
    TextView tvMsg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);
        ButterKnife.bind(this);
    }
    @Override
    protected void onResume() {
        super.onResume();
        presenter.onResume();
    }
    @Override
    public MvpPresenter initPresenter() {
        return new MvpPresenter (getApplicationContext());
    }

    @Override
    public void showMessage(){

        tvMsg.setText("有新版本需更新！");

        Toast.makeText(getApplicationContext(),"更新版本啦",Toast.LENGTH_LONG).show();

    }
}
