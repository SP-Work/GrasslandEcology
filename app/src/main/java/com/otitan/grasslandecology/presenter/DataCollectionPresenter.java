package com.otitan.grasslandecology.presenter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.otitan.grasslandecology.MyApplication;
import com.otitan.grasslandecology.util.ScreenTool;
import com.otitan.grasslandecology.view.IDataCollection;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by sp on 2019/8/2.
 * 数据采集
 */
public class DataCollectionPresenter {

    private Context mContext;
    private IDataCollection iDataCollection;

    private Banner mBn_top;

    public DataCollectionPresenter(Context context, IDataCollection iDataCollection) {
        mContext = context;
        this.iDataCollection = iDataCollection;
    }

    public void initView() {
        mBn_top = iDataCollection.getBanner();

        initBanner();
    }

    private void initBanner() {
        mBn_top.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);
        mBn_top.setImageLoader(new MyLoader());
        mBn_top.setImages(MyApplication.imgList);
        mBn_top.setBannerAnimation(Transformer.Default);
        mBn_top.setDelayTime(3000);
        mBn_top.isAutoPlay(true);
        mBn_top.setIndicatorGravity(BannerConfig.CENTER);
        mBn_top.start();

        ScreenTool.Screen screen = ScreenTool.getScreenPix(mContext);
        int width = screen.getWidthPixels();
        int height = screen.getHeightPixels() / 4;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        mBn_top.setLayoutParams(params);
    }

    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(mContext).load((int) path).into(imageView);
        }
    }
}
