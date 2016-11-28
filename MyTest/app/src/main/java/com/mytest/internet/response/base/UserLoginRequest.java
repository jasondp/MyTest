package com.mytest.internet.response.base;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserLoginRequest {
    private String token;
    private UserLoginParams params;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public UserLoginParams getParams() {
        return params;
    }

    public void setParams(UserLoginParams params) {
        this.params = params;
    }
}
