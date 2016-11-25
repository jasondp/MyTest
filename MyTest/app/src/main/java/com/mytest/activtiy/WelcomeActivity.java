package com.mytest.activtiy;

import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.mytest.R;
import com.mytest.adapter.LooperImageAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jason on 2016/11/24.
 */

public class WelcomeActivity extends BaseActivity implements ViewPager.OnPageChangeListener {

    @Bind(R.id.tutorial_grad_view)
    ViewPager welcomeViewPager;
    @Bind(R.id.looper_point_group)
    LinearLayout pointGroup;
    private LooperImageAdapter looperAdapter;
    private List<ImageView> imageList;
    private Handler handler = new Handler();
    private int[] ImageData = {R.mipmap.watch_1, R.mipmap.watch_2
            , R.mipmap.watch_3, R.mipmap.watch_4, R.mipmap.watch_5, R.mipmap.watch_6};

    private LooperTask looperTask = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_activity);
        ButterKnife.bind(this);
        initData();
    }

    private void initData() {
        imageList = new ArrayList<>();
        for (int i = 0; i < ImageData.length; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(ImageData[i]);
            imageList.add(imageView);
        }
        looperAdapter = new LooperImageAdapter(imageList);
        welcomeViewPager.setAdapter(looperAdapter);
        for (int i = 0; i < ImageData.length; i++) {
            ImageView pointImage = new ImageView(this);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
                    (ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            if (i == 0) {
                pointImage.setImageResource(R.drawable.welcome_pager_unselect_point_shape);
            } else {
                params.leftMargin = 8;
                pointImage.setImageResource(R.drawable.welcome_pager_select_point_shape);
            }
            pointImage.setLayoutParams(params);
            pointGroup.addView(pointImage);
        }
        int middlePosition = Integer.MAX_VALUE / 2;
        int middleSelectPosition = middlePosition % imageList.size();
        int initIndex = middlePosition - middleSelectPosition;
        welcomeViewPager.setCurrentItem(initIndex);
        if (looperTask == null) {
            looperTask = new LooperTask();
        }
        looperTask.start();
        welcomeViewPager.addOnPageChangeListener(this);
        welcomeViewPager.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        looperTask.stop();
                        break;
                    case MotionEvent.ACTION_CANCEL:
                    case MotionEvent.ACTION_UP:
                        looperTask.start();
                        break;
                }
                return false;
            }
        });
    }


    @OnClick(R.id.welcome_login_button)
    public void toLogin() {
        startActivity(LoginActivity.class);
        finish();
    }

    @OnClick(R.id.welcome_register_button)
    public void toRegisterAccount() {
        startActivity(RegisterActivity.class);
        finish();
    }

    class LooperTask implements Runnable {

        @Override
        public void run() {
            int currentItemIndex = welcomeViewPager.getCurrentItem();
            welcomeViewPager.setCurrentItem(++currentItemIndex);
            handler.postDelayed(this, 1500);
        }

        public void start() {
            stop();
            handler.postDelayed(this,1500);
        }

        public void stop() {
            handler.removeCallbacks(this);
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        int childCount = pointGroup.getChildCount();
        position = position % imageList.size();
        for (int i = 0; i < childCount; i++) {
            ImageView childImage = (ImageView) pointGroup.getChildAt(i);
            if (position == i) {
                childImage.setImageResource(R.drawable.welcome_pager_unselect_point_shape);
            } else {
                childImage.setImageResource(R.drawable.welcome_pager_select_point_shape);
            }
        }
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
