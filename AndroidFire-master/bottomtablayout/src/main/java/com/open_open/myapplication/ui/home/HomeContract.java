package com.open_open.myapplication.ui.home;

import com.open_open.myapplication.base.BaseModel;
import com.open_open.myapplication.base.BasePresenter;
import com.open_open.myapplication.base.BaseView;
import com.open_open.myapplication.bean.Bean;

/******************************************
 * 类名称：HomeContract
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/

public class HomeContract {

    public  interface View extends BaseView {
        void succ(Bean bean);

        void fail(String msg);
    }

    public  interface Model extends BaseModel {
        rx.Observable<Bean> login ();
    }

    public  abstract static class Presenter extends BasePresenter<Model, View> {
        abstract void login(String phone,String psw);

    }
}