package com.example.thinkpad.zhongkao.login;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.thinkpad.zhongkao.R;
import com.example.thinkpad.zhongkao.adapter.LeftAdapter;
import com.example.thinkpad.zhongkao.adapter.RightAdapter;
import com.example.thinkpad.zhongkao.base.BaseFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class LoginFragment extends BaseFragment<LoginPresenter,LoginModel> implements LoginContract.View {


    private ListView lv_left;
    private ListView lv_right;
    private Bean bean=new Bean();
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;

    @Override
    protected void initView(View inflate) {
        lv_left = inflate.findViewById(R.id.lv_left);
        lv_right = inflate.findViewById(R.id.lv_right);






      //  LeftAdapter leftAdapter=new LeftAdapter(bean,getActivity());



    }

    @Override
    protected void initData() {
        p.login("111","222");
    }

    @Override
    protected int getLayoutId() {
        return R.layout.fragment_login ;
    }


    @Override
    public void succ(Bean bean) {
        leftAdapter = new LeftAdapter(bean,getActivity());

        lv_left.setAdapter(leftAdapter);

        rightAdapter = new RightAdapter(bean,getActivity());

        lv_right.setAdapter(rightAdapter);

        lv_left.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("========didianji l geta-----");
                leftAdapter.setSelectItem(i);

                rightAdapter.setSelectItem(i);
            }
        });
    }
}
