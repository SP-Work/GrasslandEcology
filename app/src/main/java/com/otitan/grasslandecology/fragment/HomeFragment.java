package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.presenter.HomePresenter;
import com.otitan.grasslandecology.util.ScreenTool;
import com.otitan.grasslandecology.view.IHome;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;
import com.youth.banner.listener.OnBannerListener;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sp on 2019/7/18.
 * 首页
 */
public class HomeFragment extends BaseLazyFragment implements IHome {

    @BindView(R.id.bn_top)
    Banner mBn_top;
    @BindView(R.id.rv_news)
    RecyclerView mRv_news;

    private Context mContext;
    private HomePresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, inflate);

        mContext = HomeFragment.this.getContext();

        presenter = new HomePresenter(mContext, this);

        return inflate;
    }

    @Override
    public void onLazyLoad() {
        presenter.initView();
    }

    @OnClick({R.id.tv_specimen, R.id.tv_soil, R.id.tv_area, R.id.tv_quadrat, R.id.tv_more, R.id.iv_more})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.tv_specimen:
                break;
            case R.id.tv_soil:
                break;
            case R.id.tv_area:
                break;
            case R.id.tv_quadrat:
                break;

            case R.id.tv_more:
            case R.id.iv_more:
                break;
        }
    }

    @Override
    public Banner getBanner() {
        return mBn_top;
    }

    @Override
    public RecyclerView getNewsList() {
        return mRv_news;
    }
}
