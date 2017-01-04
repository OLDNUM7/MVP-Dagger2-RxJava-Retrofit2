package com.oldnum7.dagger2.scope.b;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.oldnum7.dagger2.R;
import com.oldnum7.dagger2.base.App;
import com.oldnum7.dagger2.scope.User;
import com.oldnum7.dagger2.scope.c.CActivity;

import javax.inject.Inject;

/**
 * Created by wanglj on 16/6/22.
 */

public class BActivity extends AppCompatActivity{

    @Inject
    User user;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        App.get(this).getUserComponent().plus(new BModule()).inject(this);
        TextView textView = (TextView) findViewById(R.id.text);
        textView.setText("username:"+user.getName()+"--user:"+user);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(BActivity.this, CActivity.class));
            }
        });
    }


}
