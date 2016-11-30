package com.mytest.internet.service;

import com.mytest.internet.response.body.UserLoginRequestBody;
import com.mytest.internet.result.body.UserLoginResultBody;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

/**
 * Created by Jason on 2016/11/28.
 *
 */

public interface NetWorkService {

    @Headers({"Content-Type:application/json", "Authorization:Basic YXBwczptZWRfYXBwX2RldmVsb3BtZW50"})
    @POST("/user/login")
    Call<UserLoginResultBody> userLogin(@Body UserLoginRequestBody body);

}
