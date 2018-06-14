package com.open_open.myapplication.ui.home;

import com.open_open.myapplication.bean.Bean;

/******************************************
 * 类名称：HomeModel
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/

public class HomeModel implements HomeContract.Model{

    private HomeService loginService;
    public HomeModel() {
        loginService = mretrofit.build().create(HomeService.class);
    }
    public rx.Observable<Bean> login() {
        return loginService.login();
    }
}