package com.open_open.myapplication.base;

/******************************************
 * 类名称：BasePresenter
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class BasePresenter<M, V> {
    public M mModel;
    public V mView;
    public void setMV(M m , V v){
        this.mModel=m;
        this.mView=v;
    }
}