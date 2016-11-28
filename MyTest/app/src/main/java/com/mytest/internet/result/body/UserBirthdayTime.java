package com.mytest.internet.result.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserBirthdayTime {

    @SerializedName("date")
    private String date;
    @SerializedName("timezone_type")
    private int timezone_type;
    @SerializedName("timezone")
    private String timezone;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getTimezone_type() {
        return timezone_type;
    }

    public void setTimezone_type(int timezone_type) {
        this.timezone_type = timezone_type;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
