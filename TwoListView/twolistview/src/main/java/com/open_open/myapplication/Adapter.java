package com.open_open.myapplication;

import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/******************************************
 * 类名称：Adapter
 * 类描述：
 *
 * @version: 1.0
 * @author: chj
 * @time: 2018/6/7
 * @email: chj294671171@126.com
 * @github: https://github.com/cngmsy 
 ******************************************/
public class Adapter extends BaseAdapter {


    private List<String> list=new ArrayList<>();
    Context context;
    private double selectItem;

    public Adapter(Context context,List<String> list) {
        this.list = list;
        this.context=context;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {


        View view1=View.inflate(context,R.layout.item,null);
       TextView text=view1.findViewById(R.id.text);
       text.setText(list.get(i));
        if (selectItem == i) {
            text.setTextColor(Color.BLUE);
        }else {
            text.setTextColor(Color.RED);
        }
        return view1;
    }


    public void setSelectItem(int selectItem) {

        this.selectItem = selectItem;
        notifyDataSetChanged();
    }
}
