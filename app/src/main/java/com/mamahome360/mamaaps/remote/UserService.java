package com.mamahome360.mamaaps.remote;

import com.mamahome360.mamaaps.model.LoginModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    //Login Api
    @GET("login")
    Call<LoginModel> login(@Query("username") String username, @Query("password") String password);


}
