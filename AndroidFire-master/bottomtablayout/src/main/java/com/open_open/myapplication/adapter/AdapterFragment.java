package com.open_open.myapplication.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

/******************************************
 * 类名称：AdapterFragment
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/14
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class AdapterFragment extends FragmentStatePagerAdapter {
    List<String> listTitles;
    List<Fragment> fragments;
    public AdapterFragment(FragmentManager fm,List<String> listTitles,List<Fragment> fragments) {
        super(fm);
        this.listTitles=listTitles;
        this.fragments=fragments;
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return listTitles.get(position);
    }
}
