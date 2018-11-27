package com.example.ln20181119.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ln20181119.R;
import com.example.ln20181119.bean.MyData;
import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.ArrayList;

public class MyAdapter extends BaseAdapter {
    private Context mContext;
    private ArrayList<MyData.DataBean>mList;

    public MyAdapter(Context mContext, ArrayList<MyData.DataBean> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHoulder houlder=null;
        if (convertView==null){
            houlder=new ViewHoulder();
            convertView=View.inflate(mContext, R.layout.listitem,null);
            houlder.tvImg=convertView.findViewById(R.id.tv_img);
            houlder.tvTitle=convertView.findViewById(R.id.tv_title);
            houlder.tvDate=convertView.findViewById(R.id.tv_date);
            convertView.setTag(houlder);
        }else{
            houlder= (ViewHoulder) convertView.getTag();
        }
        houlder.tvTitle.setText(mList.get(position).getNews_title());
        houlder.tvDate.setText(mList.get(position).getNews_summary());
        //Glide.with(mContext).load(mList.get(position).getPic_url()).into(houlder.tvImg);
        //ImageLoader.getInstance(mList.get(position).getPic_url()).init(houlder.tvImg);
        ImageLoader.getInstance().displayImage(mList.get(position).getPic_url(),houlder.tvImg);
        return convertView;
    }

    class ViewHoulder{
        private ImageView tvImg;
        private TextView tvTitle;
        private TextView tvDate;
    }
}
