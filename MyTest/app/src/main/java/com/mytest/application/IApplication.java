package com.mytest.application;

import android.app.Application;
import android.os.Handler;

/**
 * Created by Jason on 2016/11/25.
 */

public class IApplication extends Application {

    private Handler mHandler;

    @Override
    public void onCreate() {
        super.onCreate();
        mHandler = new Handler();
    }

    public Handler getPubicHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }
}
