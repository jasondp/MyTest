package com.mytest.application;

import android.app.Application;
import android.os.Handler;

import com.mytest.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 2016/11/25.
 */

public class IApplication extends Application {

    private Handler mHandler;
    private  Retrofit retrofit;

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

    public Retrofit getRetrofit(){
        if(retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

}
