package com.open_open.myapplication.ui.home;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.Button;

import com.open_open.myapplication.R;
import com.open_open.myapplication.adapter.AdapterFragment;
import com.open_open.myapplication.base.BaseFragment;
import com.open_open.myapplication.bean.Bean;
import com.open_open.myapplication.ui.common.CommonFragment;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.Unbinder;

/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends BaseFragment<HomePresenter, HomeModel> implements HomeContract.View {


    @BindView(R.id.tab_layout_fragment)
    TabLayout tabLayout;
    @BindView(R.id.viewpager_fragment)
    ViewPager viewpager;
    Unbinder unbinder;

    List<String> listTitles = new ArrayList<>();
    List<Fragment> fragments = new ArrayList<>();
    @BindView(R.id.btn_add)
    Button btnAdd;
    Unbinder unbinder1;
    private AdapterFragment adapterFragment;


    @Override
    protected void initView(View inflate) {
        adapterFragment = new AdapterFragment(getChildFragmentManager(), listTitles, fragments);
        viewpager.setAdapter(adapterFragment);
        tabLayout.setupWithViewPager(viewpager);
        viewpager.setCurrentItem(0);



    }

    @Override
    protected void initData() {
        for (int i = 0; i < 3; i++) {
            CommonFragment commonFragment = new CommonFragment();
            Bundle bundle = new Bundle();
            bundle.putString("key", "huanshag" + i);
            commonFragment.setArguments(bundle);
            fragments.add(commonFragment);

            listTitles.add("huanshag" + i);

        }

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CommonFragment commonFragment = new CommonFragment();
                Bundle bundle = new Bundle();
                bundle.putString("key", "我是添加的fragmetn");
                commonFragment.setArguments(bundle);
                fragments.add(commonFragment);
                listTitles.add("我是添加的fragmetn");
                adapterFragment.notifyDataSetChanged();
            }
        });
        adapterFragment.notifyDataSetChanged();
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_blank;
    }

    @Override
    public void succ(Bean bean) {

    }

    @Override
    public void fail(String msg) {

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


}
