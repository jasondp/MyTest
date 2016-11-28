package com.mytest.activtiy;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.widget.CheckBox;
import android.widget.EditText;

import com.mytest.R;
import com.mytest.util.PreferencesUtils;
import com.mytest.util.Utils;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Retrofit;

/**
 * Created by Jason on 2016/11/24.
 */

public class LoginActivity extends BaseActivity {

    @Bind(R.id.login_pager_input_account_ed)
    EditText accountEdText;
    @Bind(R.id.login_pager_input_password_ed)
    EditText passwordEdText;
    @Bind(R.id.login_memory_password)
    CheckBox memoryPassword;

    private String inputAccount;
    private String inputPassword;
    private static final int CHANGE_PASSWORD_REQUEST = 10010;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_login_layout_activity);
        ButterKnife.bind(this);
        String userAccount = PreferencesUtils.getUserAccount(this);
        String userPassword = PreferencesUtils.getUserPassword(this);
        if (userAccount != null) {
            accountEdText.setText(userAccount);
        }
        if (userPassword != null) {
            passwordEdText.setText(userPassword);
        }
    }

    @OnClick(R.id.login_user_to_register_button)
    public void openRegisterActivity() {
        startActivity(RegisterActivity.class);
    }

    @OnClick(R.id.login_forget_password)
    public void foundPassword() {
        Intent intent = new Intent(this, FoundPasswordActivity.class);
        intent.putExtra("email", inputAccount);
        startActivityForResult(intent, CHANGE_PASSWORD_REQUEST);
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @OnClick(R.id.login_activity_login_button)
    public void loginButtonClick() {
        inputAccount = accountEdText.getText().toString();
        inputPassword = passwordEdText.getText().toString();
        boolean result = checkParameter(inputAccount, inputPassword);
        if (result) {
            PreferencesUtils.saveUserAccount(this, inputAccount);
            login();
        }
    }

    private void login() {
        if (memoryPassword.isChecked()) {
            PreferencesUtils.savePassword(this, inputPassword);
        }
        Retrofit retrofit = getObject().getRetrofit();
        //Todo
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private boolean checkParameter(String inputAccount, String inputPassword) {
        boolean result = true;
        if (TextUtils.isEmpty(inputAccount)) {
            accountEdText.setError(getString(R.string.input_account_is_null), this.getDrawable(R.drawable.error_icon_drawable));
            result = false;
        }
        if (TextUtils.isEmpty(inputPassword)) {
            passwordEdText.setError(getString(R.string.input_password_is_null), this.getDrawable(R.drawable.error_icon_drawable));
            result = false;
        }
        if (!TextUtils.isEmpty(inputAccount)) {
            boolean checkEmailResult = Utils.checkEmail(inputAccount);
            if (!checkEmailResult) {
                accountEdText.setError(getString(R.string.input_account_format_error), this.getDrawable(R.drawable.error_icon_drawable));
                result = false;
            }
        }
        return result;
    }
}
