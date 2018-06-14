package com.open_open.myapplication.base;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.open_open.myapplication.App;
import com.open_open.myapplication.utils.TUtil;

import java.util.Map;

import butterknife.ButterKnife;

/******************************************
 * 类名称：BaseActivity
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public abstract class BaseActivity<T extends BasePresenter, E extends BaseModel> extends AppCompatActivity implements BaseView  {
    public T mPresenter;
    public E mModel;
    private FragmentManager manager;
    private FragmentTransaction transaction;
    private Fragment fragment;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        App.mActivity=this;
        ButterKnife.bind(this);
        init();
    }

    protected void init() {
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);
        setContentView(getLayoutResID());
        mPresenter = TUtil.getT(this, 0);
        mModel = TUtil.getT(this, 1);
        if (this instanceof BaseView) mPresenter.setMV(mModel,this );
        initFragmentManager();

        initView();


    }

    private void initFragmentManager() {
        manager = App.mActivity.getSupportFragmentManager();
        transaction = manager.beginTransaction();
    }

    public Fragment add(int containerId, Class<? extends Fragment> fragmentClass, boolean isChild, Map<String,String> map){
        //用Fragment的名字设置一个tag值
        String tag = fragmentClass.getSimpleName();
        //使用tag值来判断当前Fragment是否实例化
        fragment = manager.findFragmentByTag(tag);
        //
        if (fragment == null){
            try {
                //使用单例创建Fragment对象
                fragment = fragmentClass.newInstance();
                //使用add方法添加到容器中
                transaction.add(containerId, fragment,tag);
                //调用添加回退栈方法进行栈管理
                //addToBackStack():  添加回退栈
                transaction.addToBackStack(tag);
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        if (!isChild ) {
            if (App.mLastFragment != null){
                transaction.hide(App.mLastFragment);
            }
        }

        if (map!=null) {
            Bundle bundle=new Bundle();
            for (Map.Entry<String, String> entry : map.entrySet()) {
                bundle.putString(entry.getKey(),entry.getValue());
            }
        }
        transaction.show(fragment);
        App.mLastFragment=fragment;
        transaction.commit();
        return fragment;
    }
    /**
     * 获得Layout文件id
     *
     * @return
     */
    protected abstract int getLayoutResID();
    protected abstract void initView();
}

