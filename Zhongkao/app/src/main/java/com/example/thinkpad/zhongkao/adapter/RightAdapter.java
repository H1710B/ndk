package com.example.thinkpad.zhongkao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.thinkpad.zhongkao.R;
import com.example.thinkpad.zhongkao.login.Bean;

public class RightAdapter  extends BaseAdapter {
    Bean bean;
    Context context;
    private Bean.BodyBean.ResultBean.DictionarysBeanX dictionarysBeanX;

    public void setSelectItem(int selectItem) {
        this.selectItem = selectItem;
        notifyDataSetChanged();
    }

    private int selectItem;

    public RightAdapter(Bean bean, Context context) {
        this.bean = bean;
        this.context = context;
    }




    @Override
    public int getCount() {
        return bean.getBody().getResult().get(selectItem).getDictionarys().size();
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
        view =View.inflate(context, R.layout.lv_right_item,null);

        TextView textView=view.findViewById(R.id.tv_head);
        GridView gridView=view.findViewById(R.id.gv_item);
        dictionarysBeanX = bean.getBody().getResult().get(selectItem).getDictionarys().get(i);
        textView.setText(dictionarysBeanX.getDescription());


        GridViewAdapter gridViewAdapter=new GridViewAdapter(dictionarysBeanX.getDictionarys(),context);
        gridView.setAdapter(gridViewAdapter);

        return view;
    }
}
