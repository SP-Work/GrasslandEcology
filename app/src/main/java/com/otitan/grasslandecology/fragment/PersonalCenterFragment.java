package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.presenter.PersonalCenterPresenter;
import com.otitan.grasslandecology.view.IPersonalCenter;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sp on 2019/7/18.
 * 个人中心
 */
public class PersonalCenterFragment extends BaseLazyFragment implements IPersonalCenter {

    private Context mContext;
    private PersonalCenterPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_personal_center, null);
        ButterKnife.bind(this, inflate);

        mContext = PersonalCenterFragment.this.getContext();

        presenter = new PersonalCenterPresenter(mContext, this);

        return inflate;
    }

    @Override
    public void onLazyLoad() {
        presenter.initView();
    }

    @OnClick({R.id.ll_info, R.id.ll_data, R.id.ll_template, R.id.ll_help, R.id.ll_settings, R.id.ll_update})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.ll_info:
                presenter.test(0);
                break;
            case R.id.ll_data:
                presenter.test(1);
                break;
            case R.id.ll_template:
                presenter.test(2);
                break;
            case R.id.ll_help:
                presenter.test(3);
                break;
            case R.id.ll_settings:
                presenter.test(4);
                break;
            case R.id.ll_update:
                presenter.test(5);
                break;
        }
    }
}
