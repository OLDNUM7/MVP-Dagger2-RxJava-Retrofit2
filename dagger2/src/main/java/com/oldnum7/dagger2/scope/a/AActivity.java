package com.oldnum7.dagger2.scope.a;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.oldnum7.dagger2.R;
import com.oldnum7.dagger2.base.App;
import com.oldnum7.dagger2.scope.User;
import com.oldnum7.dagger2.scope.UserNamed;
import com.oldnum7.dagger2.scope.b.BActivity;

import javax.inject.Inject;

public class AActivity extends AppCompatActivity {
    @Inject
    User user;

    @UserNamed("a")
    @Inject
    User userA;

    @UserNamed("b")
    @Inject
    User userB;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_a);
        //注入
        App.get(this).getUserComponent().plus(new AModule()).inject(this);

        TextView textView = (TextView) findViewById(R.id.text);
//        textView.setText("username:"+user.getName()+"user:"+user);
        textView.setText("username:"+userA.getName()+"--user:"+userA+""+"username:"+userB.getName()+"--user:"+userB);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(AActivity.this, BActivity.class));
            }
        });

    }
}
