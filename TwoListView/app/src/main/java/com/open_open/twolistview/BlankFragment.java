package com.open_open.twolistview;


import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.open_open.twolistview.entity.Data;
import com.open_open.twolistview.entity.Head;

import java.util.ArrayList;
import java.util.List;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;
import se.emilsjolander.stickylistheaders.StickyListHeadersListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class BlankFragment extends Fragment implements AbsListView.OnScrollListener,AdapterView.OnItemClickListener {


    private View inflate;
    private View view;
    private ListView mLv;
    private StickyListHeadersListView   mSlh;


    //普通条目的测试数据
    private List<Data> dataList = new ArrayList<>();

    //头的测试数据
    private List<Head> headList = new ArrayList<>();




    private MyGroupAdapter groupAdapter;
    private MyHeadAdapter headAdapter;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.activity_main, container, false);

        mLv = view.findViewById(R.id.lv);
        mSlh = view.findViewById(R.id.slh);

        return view;
    }



    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        testData();

        headAdapter = new MyHeadAdapter();
        mLv.setAdapter(headAdapter);

        groupAdapter = new MyGroupAdapter();
        mSlh.setAdapter(groupAdapter);

        mLv.setOnItemClickListener(this);  //左边条目的点击事件
        mSlh.setOnScrollListener(this);   //右边滑动的监听
    }

    private boolean isScroll = false;


    /**
     * 右边滚动的事件
     */
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        //用户在滚动右边
        isScroll = true;

    }


    @Override
    public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        //左边点击  导致右边滚动 只触发这个方法
        if (isScroll) {
            Data data = dataList.get(firstVisibleItem);
            //当前正在置顶显示的头
            headAdapter.setSelectedPosition(data.headIndex);

            //滚动左边时  右边的显示问题
            int firstVisiblePosition = mLv.getFirstVisiblePosition();
            int lastVisiblePosition = mLv.getLastVisiblePosition();
            if (data.headIndex <= firstVisiblePosition || data.headIndex>=lastVisiblePosition){
                //滚动左边，右边显示对应的listview
                mLv.setSelection(data.headIndex);
            }
        }

    }


    /**
     * 左边条目的点击事件
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        headAdapter.setSelectedPosition(position);

        Head head = headList.get(position);
        mSlh.setSelection(head.groupFirstIndex);
        isScroll = false;
    }



    /**
     * 右边条目的adapter
     */
    private class MyGroupAdapter extends BaseAdapter implements StickyListHeadersAdapter {
        //分组
        @Override
        public View getHeaderView(int position, View convertView, ViewGroup parent) {
            Data data = dataList.get(position);
            //头所在集合下标
            Head head = headList.get(data.headIndex);

            TextView tv = new TextView(MyApplication.getContext());
            tv.setText(head.info);
            tv.setBackgroundColor(Color.GRAY);
            return tv;
        }

        @Override
        public long getHeaderId(int position) {
            //position是普通条目的 里面有HeadId
            int headId = dataList.get(position).headId;
            return headId;
        }

        //普通条目
        @Override
        public int getCount() {
            return dataList.size();
        }

        @Override
        public Object getItem(int position) {
            return dataList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MyApplication.getContext());
            tv.setText(dataList.get(position).info);
            tv.setTextColor(Color.GRAY);
            return tv;
        }
    }


    /**
     * 左边条目的adapter
     */
    private class MyHeadAdapter extends BaseAdapter {
        private int mSelectedPosition;

        @Override
        public int getCount() {
            return headList.size();
        }

        @Override
        public Object getItem(int position) {
            return headList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv = new TextView(MyApplication.getContext());
            tv.setText(headList.get(position).info);
            tv.setLayoutParams(new ListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, 80));
            tv.setGravity(Gravity.CENTER);
            tv.setTextSize(16);
            tv.setTextColor(Color.BLACK);
            if (position == mSelectedPosition) {
                tv.setBackgroundColor(Color.WHITE);
            } else {
                tv.setBackgroundColor(Color.GRAY);
            }

            return tv;
        }

        /**
         * 左边条目的选择
         **/
        public void setSelectedPosition(int selectedPosition) {
            if (mSelectedPosition == selectedPosition){
                return;   //不用刷新
            }
            mSelectedPosition = selectedPosition;
            notifyDataSetChanged();
        }
    }







    //获取测试数据集合
    private void testData() {

        //头条目的数据
        for (int i = 0; i < 10; i++) {
            Head head = new Head();
            head.info = "头数据:" + i;
            headList.add(head);
        }

        //获取右边的数据
        for (int j = 0; j < headList.size(); j++) {

            Head head = headList.get(j);

            for (int i = 0; i < 10; i++) {
                Data data = new Data();
                data.headId = j;  //任意值
                data.headIndex = j;
                data.info = "普通条目数据:第" + j + "组,条目数:" + i;

                if (i == 0) {     //对应组元素中第一条数据的下标
                    head.groupFirstIndex = dataList.size();
                }

                dataList.add(data);
            }
        }
    }



}
