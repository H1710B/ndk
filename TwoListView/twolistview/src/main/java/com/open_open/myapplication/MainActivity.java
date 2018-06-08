package com.open_open.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView lv1;
    List<String> list=new ArrayList<>();
    private ListView lv2;
    private Adapter adapter;
    private Adapter1 adapter1;

    //记录滑动的ListView 滑动的位置
    private int scrollPosition = -1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initData();

    }

    private void initData() {
        for (int i = 0; i < 200; i++) {
            list.add("biaoti"+i);
        }
        adapter.notifyDataSetChanged();
        adapter1.notifyDataSetChanged();

    }

    private void initView() {

        lv1 = findViewById(R.id.lv1);
        lv2 = findViewById(R.id.lv2);

        adapter = new Adapter(this,list);
        adapter1 = new Adapter1(this,list);

        lv1.setAdapter(adapter);
        lv2.setAdapter(adapter1);
        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, final int i, long l) {
               // lv1.setSelection(20);

                lv2.clearFocus();
                lv2.post(new Runnable() {
                    @Override
                    public void run() {
                       lv2.setSelection(i);
                    }
                });
                adapter1.notifyDataSetChanged();
            }
        });


        lv2.setOnScrollListener(new AbsListView.OnScrollListener() {


            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {

            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

                   adapter.setSelectItem(scrollPosition);
              //      lv1.setSelection(visibleItemCount-firstVisibleItem+scrollPosition);
                    scrollPosition = firstVisibleItem;



            }
        });
    }
}
