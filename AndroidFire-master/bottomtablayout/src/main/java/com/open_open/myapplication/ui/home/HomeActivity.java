package com.open_open.myapplication.ui.home;

import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.open_open.myapplication.R;
import com.open_open.myapplication.base.BaseActivity;
import com.open_open.myapplication.bean.TabEntity;

import java.util.ArrayList;

public class HomeActivity extends BaseActivity<HomePresenter,HomeModel> {


    private String[] mTitles = {"首页", "美女", "视频", "关注"};
    private int[] mIconUnselectIds = {
            R.mipmap.ic_home_normal, R.mipmap.ic_girl_normal, R.mipmap.ic_video_normal, R.mipmap.ic_care_normal};
    private int[] mIconSelectIds = {
            R.mipmap.ic_home_selected, R.mipmap.ic_girl_selected, R.mipmap.ic_video_selected, R.mipmap.ic_care_selected};
    private ArrayList<CustomTabEntity> mTabEntities = new ArrayList<>();
    private FrameLayout fl_body;
    private CommonTabLayout tabLayout;
    private int tabLayoutHeight;




    @Override
    protected int getLayoutResID() {
        return R.layout.activity_home;
    }


    @Override
    public void initView() {
        tabLayout = (CommonTabLayout) findViewById(R.id.tab_layout);


        tabLayout.measure(0,0);
        tabLayoutHeight =tabLayout.getMeasuredHeight();


        add(R.id.fl_body,BlankFragment.class,false,null);
        initTab();
    }



    /**
     * 初始化tab
     */
    private void initTab() {
        for (int i = 0; i < mTitles.length; i++) {
            mTabEntities.add(new TabEntity(mTitles[i], mIconSelectIds[i], mIconUnselectIds[i]));
        }
        tabLayout.setTabData(mTabEntities);
        //点击监听
        tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });
    }

    private void SwitchTo(int position) {
        switch (position){
            case 0:
                System.out.println("111");
               add(R.id.fl_body,BlankFragment.class,false,null);
                break;
            case 1:
                System.out.println("222");
                add(R.id.fl_body,BlankFragment2.class,false,null);
                break;
            case 2:
                System.out.println("333");
                add(R.id.fl_body,BlankFragment3.class,false,null);
                break;
            case 3:
                System.out.println("444");
                add(R.id.fl_body,BlankFragment4.class,false,null);
                break;

        }
    }
}
