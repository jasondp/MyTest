package com.mytest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mytest.R;

/**
 * Created by boy on 2016/11/29.
 */

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
    }
}
