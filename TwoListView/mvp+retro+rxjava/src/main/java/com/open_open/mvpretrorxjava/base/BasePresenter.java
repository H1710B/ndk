package com.open_open.mvpretrorxjava.base;

/**
 * Created by Administrator on 2018/5/30 0030.
 */

public class BasePresenter<M, V> {

    public M mModel;
    public V mView;

    public void  setMV(M m,V v){
        this.mModel=m;
        this.mView=v;
    }

}
