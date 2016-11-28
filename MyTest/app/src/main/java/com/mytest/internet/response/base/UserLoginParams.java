package com.mytest.internet.response.base;

import com.mytest.internet.response.body.UserLoginRequestBody;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserLoginParams {

    private UserLoginRequestBody user;

    public UserLoginRequestBody getUser() {
        return user;
    }

    public void setUser(UserLoginRequestBody user) {
        this.user = user;
    }
}
