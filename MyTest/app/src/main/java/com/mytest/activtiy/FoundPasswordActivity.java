package com.mytest.activtiy;

import android.content.Intent;
import android.os.Bundle;

import com.mytest.R;

/**
 * Created by Jason on 2016/11/28.
 */

public class FoundPasswordActivity extends BaseActivity {

    private String userAccount;
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.found_password_activity);
        Intent intent = getIntent();
        intent.getStringExtra("email");
    }
}
