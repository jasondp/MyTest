package com.mytest.internet.response.body;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserLoginRequestBody {

    private String email;
    private String password;

    public UserLoginRequestBody(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
