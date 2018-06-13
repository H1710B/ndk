package com.example.thinkpad.zhongkao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thinkpad.zhongkao.R;
import com.example.thinkpad.zhongkao.login.Bean;

import java.util.ArrayList;
import java.util.List;

public class GridViewAdapter extends BaseAdapter {
    List<Bean.BodyBean.ResultBean.DictionarysBeanX.DictionarysBean> lists=new ArrayList<>();

    Context context;

    public GridViewAdapter(List<Bean.BodyBean.ResultBean.DictionarysBeanX.DictionarysBean> lists, Context context) {
        this.lists = lists;
        this.context = context;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view =View.inflate(context, R.layout.leftitem1,null);
        TextView text1=view.findViewById(R.id.tv1);


        text1.setText(lists.get(i).getDescription());

        return view;

    }
}
