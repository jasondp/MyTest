package com.mytest.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import com.mytest.R;
import com.mytest.application.IApplication;

/**
 * Created by Jason on 2016/11/24.
 */

public class BaseActivity extends AppCompatActivity {
    private IApplication mIApplication;

    public IApplication getObject(){
        if(mIApplication == null){
            mIApplication = (IApplication) getApplication();
        }
        return mIApplication;
    }

    public void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
        overridePendingTransition(R.anim.activity_enter_animation, R.anim.activity_exit_animation);
    }
}
