package com.mytest.application;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.os.Handler;

import com.mytest.util.Constants;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 2016/11/25.
 */

public class IApplication extends Application {

    private Handler mHandler;
    private Retrofit retrofit;
    private BluetoothAdapter bluetoothAdapter;

    @Override
    public void onCreate() {
        super.onCreate();
    }

    public Handler getPubicHandler() {
        if (mHandler == null) {
            mHandler = new Handler();
        }
        return mHandler;
    }

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }

    public BluetoothAdapter getBluetoothAdapter(){
        if(bluetoothAdapter == null){
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return bluetoothAdapter;
    }

    public boolean startConnectDevice(BluetoothDevice bluetoothDevice) {

        return false;
    }
}
