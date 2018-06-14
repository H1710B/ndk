package com.open_open.myapplication.ui.home;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.FrameLayout;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.open_open.myapplication.R;
import com.open_open.myapplication.bean.TabEntity;

import java.util.ArrayList;

public class HomeActivity extends AppCompatActivity {


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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();


    }

    private void initView() {
        fl_body = (FrameLayout) findViewById(R.id.fl_body);
        tabLayout = (CommonTabLayout) findViewById(R.id.tab_layout);


        tabLayout.measure(0,0);
        tabLayoutHeight =tabLayout.getMeasuredHeight();

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
       /* tabLayout.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                SwitchTo(position);
            }
            @Override
            public void onTabReselect(int position) {
            }
        });*/
    }
}
