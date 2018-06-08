package com.open_open.mvpretrorxjava.loginui;

import android.view.View;
import android.widget.Button;

import com.open_open.mvpretrorxjava.R;
import com.open_open.mvpretrorxjava.base.BaseActivity;

public class MainActivity extends BaseActivity<LoginPresenter, LoginModel> implements LoginContract.View, View.OnClickListener {

    private Button btn;



    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        btn = (Button) findViewById(R.id.btn);
        btn.setOnClickListener(this);
    }

    @Override
    public void loginSucc(String str) {
        System.out.println(str);
    }

    @Override
    public void loginFail(String result) {
        System.out.println(result);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn:
                mPresenter.phoneLogin("15710062741","123456");
                break;
        }
    }
}
