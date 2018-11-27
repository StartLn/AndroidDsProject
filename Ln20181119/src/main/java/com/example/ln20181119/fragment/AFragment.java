package com.example.ln20181119.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ln20181119.R;
import com.example.ln20181119.adapter.MyFragmentAdapter;

import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class AFragment extends Fragment {
    private ArrayList<Fragment>mFragment;
    private ArrayList<String>mTitles=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_a,null);
        initData();
        initView(v);
        return v;
    }

    private void initData() {
        mFragment=new ArrayList<>();
        mFragment.add(new OneFragment());
        mFragment.add(new TwoFragment());
        mFragment.add(new ThreeFragment());
        mFragment.add(new ThreeFragment());
        mFragment.add(new ThreeFragment());
        mFragment.add(new ThreeFragment());
        mFragment.add(new ThreeFragment());
        mTitles.add("推荐");
        mTitles.add("热门");
        mTitles.add("科技");
        mTitles.add("创投");
        mTitles.add("数码");
        mTitles.add("技术");
        mTitles.add("设计");
    }

    private void initView(View v) {
        tabLayout = v.findViewById(R.id.Tab_out);
        viewPager = v.findViewById(R.id.view_age);
        viewPager.setAdapter(new MyFragmentAdapter(getChildFragmentManager(),mFragment,mTitles));
        tabLayout.setupWithViewPager(viewPager);
    }

}
