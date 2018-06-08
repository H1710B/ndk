package com.open_open.mvpretrorxjava.loginui;

import com.open_open.mvpretrorxjava.entity.Bean;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/******************************************
 * 类名称：LoginService
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/6
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public interface LoginService {
    @FormUrlEncoded
    @POST("api/account/login")//使用rxjava+retrofit  发生变化的地方就是 返回值变成了observable
    rx.Observable<Bean> login(@Field("phone") String phone, @Field("password") String psw);
}
