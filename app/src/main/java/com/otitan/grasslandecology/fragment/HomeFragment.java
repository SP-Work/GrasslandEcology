package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.otitan.grasslandecology.R;

import butterknife.ButterKnife;

/**
 * Created by sp on 2019/7/18.
 * 首页
 */
public class HomeFragment extends Fragment {

    private Context mContext;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_home, null);
        ButterKnife.bind(this, inflate);

        mContext = HomeFragment.this.getContext();

//        initView();

        return inflate;
    }
}
