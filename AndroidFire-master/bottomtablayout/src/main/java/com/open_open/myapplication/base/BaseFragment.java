package com.open_open.myapplication.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.open_open.myapplication.utils.TUtil;

import butterknife.ButterKnife;
import butterknife.Unbinder;

/******************************************
 * 类名称：BaseFragment
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public abstract class BaseFragment<P extends BasePresenter, M extends
        BaseModel> extends Fragment {
    public P p;
    public M m;
    private Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable
            ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(getLayoutId(), container, false);
        p = TUtil.getT(this, 0);
        m = TUtil.getT(this, 1);
        if (this instanceof BaseView) {
            p.setMV(m, this);
        }
        unbinder = ButterKnife.bind(this, inflate);
        initView(inflate);
        initData();
        return inflate;
    }
    protected abstract void initView(View inflate);
    protected abstract void initData();
    protected abstract int getLayoutId();


    @Override
    public void onDestroy() {
        super.onDestroy();
        unbinder.unbind();
    }
}
