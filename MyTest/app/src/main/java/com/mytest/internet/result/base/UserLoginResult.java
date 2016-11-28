package com.mytest.internet.result.base;

import com.mytest.internet.result.body.UserLoginResultBody;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserLoginResult extends BaseResult {

    private UserLoginResultBody user;

    public UserLoginResultBody getUser() {
        return user;
    }

    public void setUser(UserLoginResultBody user) {
        this.user = user;
    }
}
