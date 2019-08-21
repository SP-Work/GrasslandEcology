package com.otitan.grasslandecology.dialog;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.widget.ImageView;

import com.otitan.grasslandecology.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by sp on 2019/7/2.
 * 进度条弹窗
 */
public class LoadingDialog extends Dialog {

    @BindView(R.id.iv_loading)
    ImageView mIv_loading;

    public LoadingDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_loading);

        ButterKnife.bind(this);

        initView();
    }

    private void initView() {
        setCanceledOnTouchOutside(false);

        AnimationDrawable drawable = (AnimationDrawable) mIv_loading.getDrawable();
        drawable.run();
    }
}
