package com.mytest.application;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.os.Handler;
import android.util.Log;

import com.mytest.util.Constants;

import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 2016/11/25.
 */

public class IApplication extends Application {

    private Handler mHandler;
    private Retrofit retrofit;
    private BluetoothAdapter bluetoothAdapter;
    private BluetoothSocket rfcommSocketToServiceRecord;

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

    public BluetoothAdapter getBluetoothAdapter() {
        if (bluetoothAdapter == null) {
            bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        }
        return bluetoothAdapter;
    }

    public boolean startConnectDevice(BluetoothDevice bluetoothDevice) {
        String address = bluetoothDevice.getAddress();
        Log.i("jason","connect name:" +bluetoothDevice.getName()+"+++++++++++"+address);
        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
        if (bluetoothDevice != null) {
            try {
                rfcommSocketToServiceRecord = device.createRfcommSocketToServiceRecord(UUID.fromString(Constants.PRIVATE_UUID));
                rfcommSocketToServiceRecord.connect();
                OutputStream outputStream = rfcommSocketToServiceRecord.getOutputStream();
                if(outputStream != null){
                    //链接成功,已经建立信道！
                    return true;
                }
            } catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }

        return false;
    }
}
