package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.activity.NavigationActivity;
import com.otitan.grasslandecology.presenter.EcologicalNavigationPresenter;
import com.otitan.grasslandecology.view.IEcologicalNavigation;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sp on 2019/7/18.
 * 生态导航
 */
public class EcologicalNavigationFragment extends BaseLazyFragment implements IEcologicalNavigation {

    private Context mContext;
    private EcologicalNavigationPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_ecological_navigation, null);
        ButterKnife.bind(this, inflate);

        mContext = EcologicalNavigationFragment.this.getContext();

        presenter = new EcologicalNavigationPresenter(mContext, this);

        return inflate;
    }

    @Override
    public void onLazyLoad() {
        presenter.initView();
    }

    @OnClick({R.id.iv_layer, R.id.iv_property, R.id.iv_distance, R.id.iv_statistics, R.id.iv_delete, R.id.iv_located, R.id.tv_start})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.iv_layer:
                break;
            case R.id.iv_property:
                break;
            case R.id.iv_distance:
                break;
            case R.id.iv_statistics:
                break;
            case R.id.iv_delete:
                break;
            case R.id.iv_located:
                break;
            case R.id.tv_start:
                startActivity(new Intent(mContext, NavigationActivity.class));
                break;
        }
    }
}
