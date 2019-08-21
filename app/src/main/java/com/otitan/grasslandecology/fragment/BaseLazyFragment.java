package com.otitan.grasslandecology.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.support.v4.app.Fragment;

/**
 * Created by sp on 2019/7/19.
 * 懒加载
 */
public abstract class BaseLazyFragment extends Fragment {

    private boolean isPrepared;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        isPrepared = true;
        //只有Fragment onCreateView好了，
        //另外这里调用一次lazyLoad(）
        lazyLoad();
    }

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            lazyLoad();
        }
    }

    /**
     * 调用懒加载
     */
    private void lazyLoad() {
        if (getUserVisibleHint() && isPrepared) {
            onLazyLoad();
        }
    }

    @UiThread
    public abstract void onLazyLoad();
}
