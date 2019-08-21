package com.otitan.grasslandecology.view;

import android.support.v7.widget.RecyclerView;

import com.youth.banner.Banner;

/**
 * Created by sp on 2019/7/24.
 * 首页
 */
public interface IHome {

    Banner getBanner();

    RecyclerView getNewsList();
}
