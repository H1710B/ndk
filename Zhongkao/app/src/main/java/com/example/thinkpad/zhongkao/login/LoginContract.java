package com.example.thinkpad.zhongkao.login;

import com.example.thinkpad.zhongkao.base.BaseModel;
import com.example.thinkpad.zhongkao.base.BasePresenter;
import com.example.thinkpad.zhongkao.base.BaseView;

public class LoginContract {
    public interface View extends BaseView {
        void succ(Bean bean);
    }
    public interface Model extends BaseModel {
        rx.Observable<Bean> login ();
    }
    public abstract static class Presenter extends BasePresenter<Model, View> {
        abstract void login(String phone,String psw);
    }
}