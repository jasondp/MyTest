package com.mytest.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.mytest.R;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Jason on 2016/11/24.
 */

public class RegisterActivity extends BaseActivity {

    @Bind(R.id.register_pager_input_account_ed)
    EditText newAccountEd;
    @Bind(R.id.register_pager_input_password_ed)
    EditText firstPasswordEd;
    @Bind(R.id.register_pager_input_password_again_ed)
    EditText surePasswordEd;

    private String userEmail;
    private String userPassword;
    private String userPasswordAgain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_register_new_account_activity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.create_new_account_bt)
    public void createAccount(){
        userEmail = newAccountEd.getText().toString();
        userPassword = firstPasswordEd.getText().toString();
        userPasswordAgain = surePasswordEd.getText().toString();
        if(TextUtils.isEmpty(userEmail)){

        }
    }

    @OnClick(R.id.have_account_to_login)
    public void openLoginPager(){
        startActivity(LoginActivity.class);
    }

    public void showSnackbar(String messsage){
    }
}
