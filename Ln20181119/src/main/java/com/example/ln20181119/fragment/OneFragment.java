package com.example.ln20181119.fragment;


import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.ln20181119.R;
import com.example.ln20181119.adapter.MyAdapter;
import com.example.ln20181119.bean.MyData;
import com.example.ln20181119.helpSql.MyDao;
import com.example.ln20181119.https.HttpUtils;
import com.example.pulltolibrary.PullToRefreshBase;
import com.example.pulltolibrary.PullToRefreshListView;
import com.google.gson.Gson;
import com.recker.flybanner.FlyBanner;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class OneFragment extends Fragment {

    private String mUrl="http://api.expoon.com/AppNews/getNewsList/type/1/p/";
    private int start=1;
    private FlyBanner flyBanner;
    private PullToRefreshListView pull;
    private ArrayList<MyData.DataBean>mData=new ArrayList<>();
    private Context mContext;
    private MyAdapter myAdapter;
    private MyDao dao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v=inflater.inflate(R.layout.fragment_one,null);
        new MyTask().execute(mUrl+start);
        dao = new MyDao(getActivity().getApplicationContext());
        initView(v);
        initData();
        setListener();
        return v;
    }

    private void setListener() {
        pull.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        mData.clear();
                        start=1;
                        new MyTask().execute(mUrl+start);
                    }
                },2000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        start++;
                        new MyTask().execute(mUrl+start);
                    }
                },2000);
            }
        });
    }

    private void initData() {
        List<Integer>mPicture=new ArrayList<>();
        mPicture.add(R.drawable.lunbo2);
        mPicture.add(R.drawable.lunbo3);
        mPicture.add(R.drawable.lunbo4);
        mPicture.add(R.drawable.lunbo5);
        flyBanner.setImages(mPicture);
    }

    private void initView(View v) {
        flyBanner = v.findViewById(R.id.Fly_Banner);
        pull = v.findViewById(R.id.pull);
        pull.setMode(PullToRefreshBase.Mode.BOTH);
        mContext = getActivity().getApplicationContext();
        myAdapter = new MyAdapter(mContext, mData);
        pull.setAdapter(myAdapter);
    }

    class MyTask extends AsyncTask<String,Void,ArrayList<MyData.DataBean>>{

        @Override
        protected ArrayList<MyData.DataBean> doInBackground(String... strings) {
            String json = HttpUtils.get(strings[0]);
            Gson gson = new Gson();
            MyData data = gson.fromJson(json, MyData.class);
            return (ArrayList<MyData.DataBean>) data.getData();
        }

        @Override
        protected void onPostExecute(ArrayList<MyData.DataBean> dataBeans) {
            super.onPostExecute(dataBeans);
            mData.addAll(dataBeans);
            pull.onRefreshComplete();
            myAdapter.notifyDataSetChanged();

            long insert=dao.insert(mData);
            if (insert>0){
                Toast.makeText(getActivity(), "插入成功", Toast.LENGTH_SHORT).show();
            }
        }
    }

}
