package com.otitan.grasslandecology.presenter;

import android.content.Context;

import com.otitan.grasslandecology.view.IEcologicalNavigation;

/**
 * Created by sp on 2019/8/2.
 * 生态导航
 */
public class EcologicalNavigationPresenter {

    private Context mContext;
    private IEcologicalNavigation iEcologicalNavigation;

    public EcologicalNavigationPresenter(Context context, IEcologicalNavigation iEcologicalNavigation) {
        mContext = context;
        this.iEcologicalNavigation = iEcologicalNavigation;
    }

    public void initView() {

    }
}
