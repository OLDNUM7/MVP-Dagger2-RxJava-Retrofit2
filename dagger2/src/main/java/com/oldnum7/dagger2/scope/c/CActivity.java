package com.oldnum7.dagger2.scope.c;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.oldnum7.dagger2.MainActivity;
import com.oldnum7.dagger2.R;
import com.oldnum7.dagger2.base.App;


/**
 * Created by wanglj on 16/6/22.
 */

public class CActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                App.get(CActivity.this).releaseUserComponent();
                startActivity(new Intent(CActivity.this, MainActivity.class));
                finish();
            }
        });

    }
}
