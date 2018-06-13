package com.example.thinkpad.zhongkao.base;

public class BasePresenter<M, V> {
    public M mModel;
    public V mView;
    public void setMV(M m , V v){
        this.mModel=m;
        this.mView=v;
    }
}
