package com.open_open.myapplication.ui.common;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.open_open.myapplication.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class CommonFragment extends Fragment {


    private View view;
    private TextView textView;

    public CommonFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_common, container, false);
        textView = view.findViewById(R.id.tv_common_fragment);

        if (getArguments()!= null) {
            textView.setText(getArguments().getString("key"));;

        }

        return view;
    }

    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if (!hidden ) {
            if (textView != null) {
                textView.setText(getArguments().getString("key"));
            }
        }
    }
}
