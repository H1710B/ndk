package com.open_open.myapplication.ui.home;

import com.open_open.myapplication.bean.Bean;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/******************************************
 * 类名称：HomePresenter
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class HomePresenter extends HomeContract.Presenter{
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
                        mView.fail(throwable.getMessage());
                    }
                });
    }
}
