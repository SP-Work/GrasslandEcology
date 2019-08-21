package com.otitan.grasslandecology.presenter;

import android.content.Context;
import android.view.View;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.util.ToastUtil;
import com.otitan.grasslandecology.view.IPersonalCenter;

import butterknife.OnClick;

/**
 * Created by sp on 2019/7/24.
 * 个人中心
 */
public class PersonalCenterPresenter {

    private Context mContext;
    private IPersonalCenter iPersonalCenter;

    public PersonalCenterPresenter(Context context, IPersonalCenter iPersonalCenter) {
        mContext = context;
        this.iPersonalCenter = iPersonalCenter;
    }

    public void initView() {
        ToastUtil.setToast(mContext, "个人中心");
    }

    public void test(int index) {
        switch (index) {
            case 0:
                ToastUtil.setToast(mContext, "0");
                break;
            case 1:
                ToastUtil.setToast(mContext, "1");
                break;
            case 2:
                ToastUtil.setToast(mContext, "2");
                break;
            case 3:
                ToastUtil.setToast(mContext, "3");
                break;
            case 4:
                ToastUtil.setToast(mContext, "4");
                break;
            case 5:
                ToastUtil.setToast(mContext, "5");
                break;
        }
    }
}
