package com.mytest.activity;

import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import com.mytest.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by boy on 2016/11/28.
 */

public class GuideActivity3 extends BaseActivity {

    private static final int OPEN_BLUETOOTH = 10086;
    private boolean isOPen = false;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.guide_3_activity);
        ButterKnife.bind(this);
        BluetoothAdapter bluetoothAdapter = getObject().getBluetoothAdapter();
        if (bluetoothAdapter != null) {
            if (!bluetoothAdapter.isEnabled()) {
                Intent intent = new Intent(BluetoothAdapter.ACTION_REQUEST_ENABLE);
                startActivityForResult(intent, OPEN_BLUETOOTH);
            }else{
                isOPen = true;
            }
        }
    }

    @OnClick(R.id.activity_tutorial_4_next_button)
    public void nextPager() {
        if (isOPen) {
            startActivity(ConnectionWatchActivity.class);
        } else {
            Toast.makeText(this, getString(R.string.please_open_bluetooth), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == OPEN_BLUETOOTH) {
            isOPen = true;
        }
    }
}
