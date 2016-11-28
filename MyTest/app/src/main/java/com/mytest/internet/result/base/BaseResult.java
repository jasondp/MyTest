package com.mytest.internet.result.base;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jason on 2016/11/28.
 */

public class BaseResult {

    @SerializedName("version")
    private float version;
    @SerializedName("message")
    private String message;
    @SerializedName("status")
    private int status;

    public float getVersion() {
        return version;
    }

    public void setVersion(float version) {
        this.version = version;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
