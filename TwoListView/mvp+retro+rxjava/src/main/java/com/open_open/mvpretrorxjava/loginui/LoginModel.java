package com.open_open.mvpretrorxjava.loginui;

import com.open_open.mvpretrorxjava.entity.Bean;

import rx.Observable;

/******************************************
 * 类名称：LoginModel
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/6
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class LoginModel implements LoginContract.Model {

    private final LoginService loginService;

    public LoginModel() {
        loginService = mRetrofitManager.build().create(LoginService.class);
    }

    @Override
    public Observable<Bean> loginByPsw(String phone, String code) {
        return loginService.login(phone,code);
    }
}
