package com.oldnum7.dagger2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

import com.oldnum7.dagger2.base.App;
import com.oldnum7.dagger2.scope.User;
import com.oldnum7.dagger2.scope.a.AActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        final EditText etUserName = (EditText) findViewById(R.id.username);
        final EditText etPassword = (EditText) findViewById(R.id.password);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                User user = new User();
                user.setName(etUserName.getText().toString() + "AAA");
                user.setAvatar(etPassword.getText().toString());


                User userA = new User();
                userA.setName(etUserName.getText().toString()+"BBB");
                userA.setAvatar(etPassword.getText().toString());

                User userB = new User();
                userB.setName(etUserName.getText().toString()+"BBB");
                userB.setAvatar(etPassword.getText().toString());

//                App.get(LoginActivity.this).createUserComponent(user);
//                startActivity(new Intent(LoginActivity.this, AActivity.class));

                App.get(LoginActivity.this).createUserComponent(userA,userB);
                startActivity(new Intent(LoginActivity.this, AActivity.class));

            }
        });

    }
}
