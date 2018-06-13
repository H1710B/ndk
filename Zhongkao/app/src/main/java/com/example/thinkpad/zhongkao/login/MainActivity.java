package com.example.thinkpad.zhongkao.login;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.example.thinkpad.zhongkao.R;
import com.example.thinkpad.zhongkao.base.BaseActivity;
import com.example.thinkpad.zhongkao.login.LoginContract;
import com.example.thinkpad.zhongkao.login.LoginModel;
import com.example.thinkpad.zhongkao.login.LoginPresenter;

public class MainActivity extends BaseActivity<LoginPresenter,LoginModel> implements LoginContract.View {


    @Override
    protected int getLayoutResID() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        add(R.id.fl_container,LoginFragment.class,false,null);
       // mPresenter.login("15226206005","123456");
    }

    @Override
    public void succ(Bean bean) {

    }
}
