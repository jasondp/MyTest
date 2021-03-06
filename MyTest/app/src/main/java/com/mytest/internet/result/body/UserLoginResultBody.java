package com.mytest.internet.result.body;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Jason on 2016/11/28.
 */

public class UserLoginResultBody {

    @SerializedName("id")
    private int id;
    @SerializedName("last_name")
    private String last_name;
    @SerializedName("first_name")
    private String first_name;
    @SerializedName("birthday")
    private UserBirthdayTime birthday;
    @SerializedName("weight")
    private float weight;
    @SerializedName("length")
    private int length;
    @SerializedName("sex")
    private int sex;
    @SerializedName("last_longitude")
    private int last_longitude;
    @SerializedName("latitude")
    private int last_latitude;
    @SerializedName("email")
    private String email;
    @SerializedName("verified_email")
    private boolean verified_email;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public UserBirthdayTime getBirthday() {
        return birthday;
    }

    public void setBirthday(UserBirthdayTime birthday) {
        this.birthday = birthday;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public int getLast_longitude() {
        return last_longitude;
    }

    public void setLast_longitude(int last_longitude) {
        this.last_longitude = last_longitude;
    }

    public int getLast_latitude() {
        return last_latitude;
    }

    public void setLast_latitude(int last_latitude) {
        this.last_latitude = last_latitude;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isVerified_email() {
        return verified_email;
    }

    public void setVerified_email(boolean verified_email) {
        this.verified_email = verified_email;
    }
}
