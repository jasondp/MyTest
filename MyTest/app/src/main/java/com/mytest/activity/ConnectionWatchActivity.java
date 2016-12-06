package com.mytest.activity;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.mytest.R;
import com.mytest.adapter.ShowSearchAllDeviceAdapter;
import com.mytest.application.IApplication;
import com.mytest.modle.SearchDeviceModel;
import com.mytest.util.Constants;

import java.util.List;

/**
 * Created by boy on 2016/11/28.
 */

public class ConnectionWatchActivity extends BaseActivity {

    private BluetoothAdapter bluetoothAdapter;
    private ProgressDialog mProgressDialog;
    private IApplication model;
    private static final int OPEN_DEVICE_RESULT = 1002;
    private List<SearchDeviceModel> mSearchDevice;
    private ListView mListView;
    private ImageView watchIcon;
    private ShowSearchAllDeviceAdapter resultAdapter;



    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_search_watch_activity);
        model = getObject();
        mListView = (ListView) findViewById(R.id.show_search_all_device_list_view);
        watchIcon = (ImageView) findViewById(R.id.watch_icon);
        mListView.setVisibility(View.GONE);
        bluetoothAdapter = model.getBluetoothAdapter();
        init();

    }

    private void init() {
        if (bluetoothAdapter.isEnabled()) {
            Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
            startActivityForResult(intent, OPEN_DEVICE_RESULT);
        } else {
            startSearchDevices();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == OPEN_DEVICE_RESULT) {
            startSearchDevices();
        }
    }

    private void startSearchDevices() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.wait_some_time));
        mProgressDialog.show();
        model.startSearchDevice();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(Constants.SCAN_OVER);
        registerReceiver(searchDeviceReceiver, intentFilter);

    }

    private BroadcastReceiver searchDeviceReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            mProgressDialog.dismiss();
            mSearchDevice = getObject().getSearchDevice();
            if(mSearchDevice.size()>0){
                watchIcon.setVisibility(View.GONE);
                mListView.setVisibility(View.VISIBLE);
            }
            resultAdapter = new ShowSearchAllDeviceAdapter(ConnectionWatchActivity.this,mSearchDevice);
            mListView.setAdapter(resultAdapter);
        }
    };

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(searchDeviceReceiver);
    }
}
