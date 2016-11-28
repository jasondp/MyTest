package com.mytest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mytest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by boy on 2016/11/29.
 */

public class AgainFoundDeviceActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.again_found_device_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_tutorial_retry_button)
    public void againConnect(){
        startActivity(ConnectionWatchActivity.class);
        finish();
    }
}
