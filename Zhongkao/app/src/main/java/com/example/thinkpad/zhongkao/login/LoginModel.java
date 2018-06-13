package com.example.thinkpad.zhongkao.login;

import rx.Observable;

public class LoginModel implements LoginContract.Model {
    private LoginService loginService;
    public LoginModel() {
        loginService = mretrofit.build().create(LoginService.class);
    }
    public rx.Observable<Bean> login() {
        return loginService.login();
    }
}
