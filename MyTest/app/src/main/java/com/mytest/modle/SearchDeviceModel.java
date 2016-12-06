package com.mytest.modle;

/**
 * Created by Jason on 2016/12/6.
 */

public class SearchDeviceModel {
    private String name;
    private String address;

    public SearchDeviceModel(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SearchDeviceModel{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", uuid='"+ '\'' +
                '}';
    }
}
