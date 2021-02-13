package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;

public interface Api {

    @POST("users/save")
    Call<Register> userregister(@Body Register register);

    @POST("auth/login")
    Call<UserTokenState> createPost(@Body UsernamePassReq usernamePassReq);

    @GET("users/all")
    Call<List<Register>> getUsers(@Header("Authorization") String authorization);

}

