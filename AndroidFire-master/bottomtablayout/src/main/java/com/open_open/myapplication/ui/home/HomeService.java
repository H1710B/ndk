package com.open_open.myapplication.ui.home;

import com.open_open.myapplication.bean.Bean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/******************************************
 * 类名称：HomeService
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/

public interface HomeService {
    @FormUrlEncoded
    @POST("api/account/login")
    rx.Observable<Bean>login(@Field("phone") String
                                     phone, @Field("password") String psw);
    @GET("yunxue_app_api/diction/getdictionaryswithpid/KECHENGFENLEI")
    rx.Observable<Bean>login();
}

