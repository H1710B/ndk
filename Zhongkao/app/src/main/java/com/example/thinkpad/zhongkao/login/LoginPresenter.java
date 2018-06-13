package com.example.thinkpad.zhongkao.login;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class LoginPresenter extends LoginContract.Presenter {
    public void login(String phone, String psw) {
        mModel.login()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Action1<Bean>() {
                    @Override
                    public void call(Bean bean) {
                        mView.succ(bean);
                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) {
                      //  mView.succ(throwable.getMessage());
                    }
                });
    }
}