package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.presenter.PlantRecognitionPresenter;
import com.otitan.grasslandecology.view.IPlantRecognition;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sp on 2019/7/18.
 * 植图识别
 */
public class PlantRecognitionFragment extends BaseLazyFragment implements IPlantRecognition {

    @BindView(R.id.iv_plant)
    ImageView mIv_plant;
    @BindView(R.id.tv_result)
    TextView mTv_result;
    @BindView(R.id.tv_score)
    TextView mTv_score;
    @BindView(R.id.tv_description)
    TextView mTv_description;
    @BindView(R.id.rv_result)
    RecyclerView mRv_result;
    @BindView(R.id.rv_plant)
    RecyclerView mRv_plant;

    private Context mContext;
    private PlantRecognitionPresenter presenter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_plant_recognition, null);
        ButterKnife.bind(this, inflate);

        mContext = PlantRecognitionFragment.this.getContext();

        presenter = new PlantRecognitionPresenter(mContext, this);

        return inflate;
    }

    @Override
    public void onLazyLoad() {
        presenter.initView();

        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(intent, 0);
    }

    @OnClick({R.id.tv_camera, R.id.tv_history})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.tv_camera:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量，启动相机的关键
                startActivityForResult(intent, 0); // 参数常量为自定义的request code, 在取返回结果时有用
                break;

            case R.id.tv_history:
                presenter.showHistory();
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 0 && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            presenter.getBitmapByte(bitmap);
        }
    }

    @Override
    public ImageView getIVTest() {
        return mIv_plant;
    }

    @Override
    public TextView getTVResult() {
        return mTv_result;
    }

    @Override
    public TextView getTVScore() {
        return mTv_score;
    }

    @Override
    public TextView getTVDescription() {
        return mTv_description;
    }

    @Override
    public RecyclerView getResultList() {
        return mRv_result;
    }

    @Override
    public RecyclerView getPlantList() {
        return mRv_plant;
    }
}
