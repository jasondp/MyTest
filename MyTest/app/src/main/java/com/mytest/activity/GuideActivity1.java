package com.mytest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mytest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by boy on 2016/11/28.
 */

public class GuideActivity1 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guyide_1_activtity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_tutorial_1_activate_button)
    public void nextPager(){
        startActivity(GuideActivity2.class);
        finish();
    }
}
