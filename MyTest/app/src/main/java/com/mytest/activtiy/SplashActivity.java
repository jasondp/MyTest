package com.mytest.activtiy;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.ImageView;

import com.mytest.R;

import butterknife.Bind;
import butterknife.ButterKnife;

import static android.view.animation.Animation.RELATIVE_TO_PARENT;

public class SplashActivity extends BaseActivity implements Animation.AnimationListener, View.OnClickListener {

    @Bind(R.id.splash_watch_1)
    ImageView splashImage;
    @Bind(R.id.splash_next_bt)
    Button nextButton;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        startAnim();
        nextButton.setOnClickListener(this);
    }

    private void startAnim() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0.5f, 1f, 0.5f, 1f,
                RELATIVE_TO_PARENT, 0.5f, RELATIVE_TO_PARENT, 0.5f);
        scaleAnimation.setDuration(3000);
        scaleAnimation.setFillAfter(false);
        splashImage.setAnimation(scaleAnimation);
        scaleAnimation.start();
        scaleAnimation.setAnimationListener(this);
    }

    @Override
    public void onAnimationStart(Animation animation) {
    }

    @Override
    public void onAnimationEnd(Animation animation) {
        nextButton.setVisibility(View.VISIBLE);
    }

    @Override
    public void onAnimationRepeat(Animation animation) {

    }

    @Override
    public void onClick(View v) {
        startActivity(WelcomeActivity.class);
    }

}
