package com.otitan.grasslandecology.presenter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.otitan.grasslandecology.MyApplication;
import com.otitan.grasslandecology.util.ScreenTool;
import com.otitan.grasslandecology.view.IHome;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

/**
 * Created by sp on 2019/7/24.
 * 首页
 */
public class HomePresenter implements OnBannerListener {

    private Context mContext;
    private IHome iHome;

    private Banner mBn_top;
    private RecyclerView mRv_news;

    public HomePresenter(Context context, IHome iHome) {
        mContext = context;
        this.iHome = iHome;
    }

    public void initView() {
        mBn_top = iHome.getBanner();
        mRv_news = iHome.getNewsList();

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
        mBn_top.setOnBannerListener(this);
        mBn_top.start();

        ScreenTool.Screen screen = ScreenTool.getScreenPix(mContext);
        int width = screen.getWidthPixels();
        int height = screen.getHeightPixels() / 4;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        mBn_top.setLayoutParams(params);
    }

    /**
     * 轮播图的监听方法
     */
    @Override
    public void OnBannerClick(int position) {

    }

    /**
     * 自定义的图片加载器
     */
    private class MyLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            Picasso.with(mContext).load((int) path).into(imageView);
        }
    }
}
