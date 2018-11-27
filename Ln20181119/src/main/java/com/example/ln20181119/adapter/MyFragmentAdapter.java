package com.example.ln20181119.adapter;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

public class MyFragmentAdapter extends FragmentPagerAdapter {
    private ArrayList<Fragment>mDatas;
    private ArrayList<String>mTitle;

    public MyFragmentAdapter(FragmentManager fm, ArrayList<Fragment> mDatas, ArrayList<String> mTitle) {
        super(fm);
        this.mDatas = mDatas;
        this.mTitle = mTitle;
    }

    @Override
    public Fragment getItem(int i) {
        return mDatas.get(i);
    }

    @Override
    public int getCount() {
        return mDatas.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return mTitle.get(position);
    }
}
