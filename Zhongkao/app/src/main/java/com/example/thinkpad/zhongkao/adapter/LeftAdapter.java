package com.example.thinkpad.zhongkao.adapter;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.thinkpad.zhongkao.R;
import com.example.thinkpad.zhongkao.login.Bean;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends BaseAdapter {

   Bean bean;
    Context context;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    private int selectItem;

    public LeftAdapter(Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }



    @Override
    public int getCount() {
        return bean.getBody().getResult().size();
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
        view =View.inflate(context, R.layout.leftitem,null);
        TextView text=view.findViewById(R.id.titles);
        System.out.println("======"+bean.getBody().getResult().get(i).getDescription());
        text.setText(bean.getBody().getResult().get(i).getDescription());


        if (selectItem == i) {
            text.setTextColor(Color.RED);
        }else   text.setTextColor(Color.BLACK);
        return view;
    }
}
