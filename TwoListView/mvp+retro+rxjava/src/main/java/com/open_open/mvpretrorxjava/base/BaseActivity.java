package com.open_open.mvpretrorxjava.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.WindowManager;

import com.open_open.mvpretrorxjava.utils.TUtil;


/**
 * Activity基类
 * Created by z2wenfa on 2016/8/25.
 */
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends Activity implements BaseView  {
    public T mPresenter;
    public E mModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        init();
    }

    protected void init() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getLayoutResID());
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) mPresenter.setMV(mModel,this );

        initView();


    }

    /**
     * 获得Layout文件id
     *
     * @return
     */
    protected abstract int getLayoutResID();


    protected abstract void initView();







}
