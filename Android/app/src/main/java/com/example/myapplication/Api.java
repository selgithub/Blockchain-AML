package com.example.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Api {

    @POST("users/save")
    Call<Register> userregister(@Body Register register);

    @POST("accounts/save")
    Call<AccountRegister> accountregister(@Header("Authorization") String authorization, @Body CreateAccount acc);

    @POST("auth/login")
    Call<UserTokenState> createPost(@Body UsernamePassReq usernamePassReq);

    @GET("users/all")
    Call<List<Register>> getUsers(@Header("Authorization") String authorization);

    @GET("accounts/all")
    Call<List<AccountRegister>> getAccountById(@Header("Authorization") String authorization);
}

