package com.open_open.mvpretrorxjava.loginui;

import com.open_open.mvpretrorxjava.base.BaseModel;
import com.open_open.mvpretrorxjava.base.BasePresenter;
import com.open_open.mvpretrorxjava.base.BaseView;
import com.open_open.mvpretrorxjava.entity.Bean;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class LoginContract {

    public interface View extends BaseView {
      void loginSucc(String str);
      void loginFail(String result);
    }

    public interface Model  extends BaseModel {
        rx.Observable<Bean> loginByPsw(String phone, String code);
    }


    public abstract static class Presenter extends BasePresenter<Model, View> {
      abstract void phoneLogin(String phone,String psw);

        
    }
}