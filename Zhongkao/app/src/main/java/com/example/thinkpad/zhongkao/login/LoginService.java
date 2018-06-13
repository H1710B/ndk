package com.example.thinkpad.zhongkao.login;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface LoginService {
    @FormUrlEncoded
    @POST("api/account/login")
    rx.Observable<Bean>login(@Field("phone")String
                                     phone,@Field("password")String psw);

    @GET("yunxue_app_api/diction/getdictionaryswithpid/KECHENGFENLEI")
    rx.Observable<Bean>login();



}