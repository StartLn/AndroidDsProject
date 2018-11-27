package com.example.ln20181119;

import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.ln20181119.adapter.MyFragmentAdapter;
import com.example.ln20181119.fragment.AFragment;
import com.example.ln20181119.fragment.BFragment;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<Fragment>mList=new ArrayList<>();
    private ArrayList<String>mTitle=new ArrayList<>();
    private TabLayout tabLayout;
    private ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initData();
        initView();
    }

    private void initData() {
        mList.add(new AFragment());
        mList.add(new BFragment());
        mList.add(new BFragment());
        mList.add(new BFragment());
        mList.add(new BFragment());
        mTitle.add("文章");
        mTitle.add("站点");
        mTitle.add("主题");
        mTitle.add("发展");
        mTitle.add("我的");
    }

    private void initView() {
        tabLayout = findViewById(R.id.Tab_layout);
        viewPager = findViewById(R.id.view_page);
        viewPager.setAdapter(new MyFragmentAdapter(getSupportFragmentManager(),mList,mTitle));
        tabLayout.setupWithViewPager(viewPager);
    }
}
