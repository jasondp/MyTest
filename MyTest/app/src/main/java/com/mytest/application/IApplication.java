package com.mytest.application;

import android.app.Application;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Intent;
import android.os.Handler;
import android.util.Log;
import android.widget.Toast;

import com.mytest.modle.SearchDeviceModel;
import com.mytest.util.Constants;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Jason on 2016/11/25.
 */

public class IApplication extends Application {

    private Handler mHandler;
    private Retrofit retrofit;
    private BluetoothAdapter bluetoothAdapter;
    private List<SearchDeviceModel> searchResult;

    @Override
    public void onCreate() {
        super.onCreate();
        searchResult = new ArrayList<>();
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

    public List<SearchDeviceModel> getSearchDevice() {
        if (searchResult != null) {
            return searchResult;
        }
        return searchResult = new ArrayList<>();
    }

    public boolean startConnectDevice(String address) {

        return false;
    }

    public void startSearchDevice() {
        final BluetoothAdapter bluetoothAdapter = getBluetoothAdapter();
        if (bluetoothAdapter.isEnabled()) {
            if (!bluetoothAdapter.isDiscovering()) {
                getPubicHandler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        bluetoothAdapter.stopLeScan(mLeScanCallback);
                        Intent intent = new Intent(Constants.SCAN_OVER);
                        sendBroadcast(intent);
                    }
                }, 10000);
                bluetoothAdapter.startLeScan(mLeScanCallback);
            } else {
                Toast.makeText(this, "请开启蓝牙...", Toast.LENGTH_SHORT).show();
            }
        }
    }

    private BluetoothAdapter.LeScanCallback mLeScanCallback = new BluetoothAdapter.LeScanCallback() {
        @Override
        public void onLeScan(BluetoothDevice device, int rssi, byte[] scanRecord) {
            Log.i("jason", "scanRecord :" + scanRecord.toString());
            Log.i("jason", "rssi :" + rssi + "");
            String name = device.getName();
            String address = device.getAddress();
            SearchDeviceModel searchDeviceModel = new SearchDeviceModel(name, address);
            searchResult.add(searchDeviceModel);
        }
    };
}
