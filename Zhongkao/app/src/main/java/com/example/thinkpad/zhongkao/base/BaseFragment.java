package com.example.thinkpad.zhongkao.base;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.thinkpad.zhongkao.utils.TUtil;

public abstract class BaseFragment<P extends BasePresenter, M extends
        BaseModel> extends Fragment {
    public P p;
    public M m;
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
        initView(inflate);
        initData();
        return inflate;
    }
    protected abstract void initView(View inflate);
    protected abstract void initData();
    protected abstract int getLayoutId();
}