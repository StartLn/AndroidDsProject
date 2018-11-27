package com.example.ln20181119.MyApp;

import android.app.Application;
import android.graphics.Bitmap;

import com.example.ln20181119.R;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.display.CircleBitmapDisplayer;

public class apps extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        DisplayImageOptions displayImageOptions=new DisplayImageOptions.Builder()
                .showImageForEmptyUri(R.drawable.ic_launcher_background)
                .showImageOnFail(R.mipmap.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)
                .displayer(new CircleBitmapDisplayer())
                .build();

        ImageLoaderConfiguration ImageLoaderConfiguration=new ImageLoaderConfiguration.Builder(this)
                .defaultDisplayImageOptions(displayImageOptions)
                .build();
        ImageLoader.getInstance().init(ImageLoaderConfiguration);

        /*.showStubImage(R.drawable.ic_launcher)
                .showImageForEmptyUri(R.mipmap.ic_launcher)
                .showImageOnFail(R.drawable.ic_launcher)
                .cacheInMemory(true)
                .cacheOnDisc(true)
                .bitmapConfig(Bitmap.Config.ARGB_8888)   //设置图片的解码类型
                .displayer(new CircleBitmapDisplayer())//加载圆角图片*/
    }
}
