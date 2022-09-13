package com.example.login_wepapi;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface API {
    @FormUrlEncoded
    @POST("name")
    Call<Model> addperson(@Field("Password") String Password);
}
