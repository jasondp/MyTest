package com.mytest.activity;

import android.app.ProgressDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.mytest.R;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

/**
 * Created by boy on 2016/11/28.
 */

public class ConnectionWatchActivity extends BaseActivity {

    private BluetoothAdapter bluetoothAdapter;
    private Set<BluetoothDevice> bondedDevices;
    private List<BluetoothDevice> usableDevice;
    private long olderTime;
    private ProgressDialog mProgressDialog;

    private BroadcastReceiver foundDevice = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if (action.equals(BluetoothDevice.ACTION_FOUND)) {
                BluetoothDevice bluetoothDevice = intent.getParcelableExtra
                        (BluetoothDevice.EXTRA_DEVICE);
                Log.i("jason", bluetoothDevice.getName() + " : " + bluetoothDevice.getAddress());
                if (bluetoothDevice.getName().contains("Nevo")
                        && bluetoothDevice.getBondState() != BluetoothDevice.BOND_BONDED) {
                    usableDevice.add(bluetoothDevice);
                }
            } else if (action.equals(BluetoothAdapter.ACTION_DISCOVERY_FINISHED)) {
                mProgressDialog.dismiss();
                if (usableDevice.size() <= 0) {
                    Toast.makeText(ConnectionWatchActivity.this
                            , getString(R.string.not_found_device), Toast.LENGTH_SHORT).show();
                    startActivity(AgainFoundDeviceActivity.class);
                    finish();
                } else {
                    for (int i = 0; i < usableDevice.size(); i++) {
                        boolean isConnect = getObject().startConnectDevice(usableDevice.get(i));
                        if (isConnect == true) {
                            startActivity(MainActivity.class);
                            finish();
                            break;
                        } else if (i == (usableDevice.size() - 1) && isConnect == false) {
                            startActivity(AgainFoundDeviceActivity.class);
                            finish();
                        }
                    }
                }
            }
        }
    };


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.connection_search_watch_activity);
        bluetoothAdapter = getObject().getBluetoothAdapter();
        bondedDevices = bluetoothAdapter.getBondedDevices();
        usableDevice = new ArrayList<>();
        olderTime = System.currentTimeMillis();
        if (bluetoothAdapter.isDiscovering()) {
            bluetoothAdapter.cancelDiscovery();
        }
        if (bondedDevices.size() > 0) {
            for (BluetoothDevice device : bondedDevices) {
                if (device.getName().contains("Nevo")) {
                    usableDevice.add(device);
                }
            }
        } else {
            startSearchDevices();
        }

        if (usableDevice.size() <= 0) {
            startSearchDevices();
        }
    }

    private void startSearchDevices() {
        mProgressDialog = new ProgressDialog(this);
        mProgressDialog.setMessage(getString(R.string.wait_some_time));
        mProgressDialog.show();
        IntentFilter intentFilter = new IntentFilter(BluetoothDevice.ACTION_FOUND);
        registerReceiver(foundDevice, intentFilter);
        intentFilter = new IntentFilter(BluetoothAdapter.ACTION_DISCOVERY_FINISHED);
        registerReceiver(foundDevice, intentFilter);
        bluetoothAdapter.startDiscovery();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(foundDevice);
    }
}
