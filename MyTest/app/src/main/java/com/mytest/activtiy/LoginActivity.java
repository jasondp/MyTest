package com.mytest.activtiy;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mytest.R;

/**
 * Created by Jason on 2016/11/24.
 */

public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout_activity);
    }
}
