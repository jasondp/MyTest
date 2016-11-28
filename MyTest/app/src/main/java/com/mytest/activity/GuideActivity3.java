package com.mytest.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.mytest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by boy on 2016/11/28.
 */

public class GuideActivity3 extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_3_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.activity_tutorial_4_next_button)
    public void nextPager(){
        startActivity(ConnectionWatchActivity.class);
    }
}
