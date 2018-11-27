package com.example.ln20181119.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.ln20181119.R;
import com.example.ln20181119.helpSql.MyDao;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwoFragment extends Fragment {


    private TextView tvContext;
    private MyDao dao;
    private String select;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_two,null);
        initView(v);
        dao = new MyDao(getActivity().getApplicationContext());
        select = dao.select();
        tvContext.setText(select +"");
        return v;
    }

    private void initView(View v) {
        tvContext = v.findViewById(R.id.tvcontext);

    }

}
