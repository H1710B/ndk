package com.open_open.mvpretrorxjava.loginui;

import com.open_open.mvpretrorxjava.entity.Bean;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/******************************************
 * 类名称：LoginPresenter
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/6
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class LoginPresenter extends LoginContract.Presenter {
    @Override
    void phoneLogin(String phone, String psw) {
        mModel.loginByPsw(phone, psw).subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bean>() {
                               @Override
                               public void call(Bean bean) {

                                   mView.loginSucc(bean.getMessage());
                               }
                           }, new Action1<Throwable>() {
                               @Override
                               public void call(Throwable throwable) {

                                   mView.loginFail(throwable.getMessage());
                               }
                           }

                );
    }
}
