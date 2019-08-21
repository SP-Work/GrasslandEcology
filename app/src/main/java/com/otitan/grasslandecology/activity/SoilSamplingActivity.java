package com.otitan.grasslandecology.activity;

import android.content.Context;
import android.content.Intent;
import android.provider.MediaStore;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.presenter.SoilSamplingPresenter;
import com.otitan.grasslandecology.view.ISoilSampling;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * 土壤采样
 */
public class SoilSamplingActivity extends AppCompatActivity implements ISoilSampling {

    // 位置信息
    @BindView(R.id.et_city)
    EditText mEt_city;
    @BindView(R.id.et_location)
    EditText mEt_location;
    @BindView(R.id.et_lon)
    EditText mEt_lon;
    @BindView(R.id.et_lat)
    EditText mEt_lat;
    @BindView(R.id.et_altitude)
    EditText mEt_altitude;
    @BindView(R.id.et_date)
    EditText mEt_date;
    @BindView(R.id.tv_sunny)
    TextView mTv_sunny;
    @BindView(R.id.tv_overcast)
    TextView mTv_overcast;
    @BindView(R.id.tv_rain)
    TextView mTv_rain;
    @BindView(R.id.tv_wind)
    TextView mTv_wind;

    // 草地信息
    @BindView(R.id.et_grasslandType)
    EditText mEt_grasslandType; // 草原类型
    @BindView(R.id.tv_serious)
    TextView mTv_serious; // 重度
    @BindView(R.id.tv_moderate)
    TextView mTv_moderate; // 中度
    @BindView(R.id.tv_mild)
    TextView mTv_mild; // 轻度
    @BindView(R.id.et_dominant)
    EditText mEt_dominant; // 优势植物

    // 土壤信息
    @BindView(R.id.tv_flatland)
    TextView mTv_flatland; // 平原
    @BindView(R.id.tv_mountain)
    TextView mTv_mountain; // 山地
    @BindView(R.id.tv_hills)
    TextView mTv_hills; // 丘陵
    @BindView(R.id.tv_wetlands)
    TextView mTv_wetlands; // 湿地

    @BindView(R.id.et_soilType)
    EditText mEt_soilType; // 土壤类型
    @BindView(R.id.et_profileDepth)
    EditText mEt_profileDepth; // 剖面深度

    @BindView(R.id.tv_black)
    TextView mTv_black; // 黑
    @BindView(R.id.tv_brown)
    TextView mTv_brown; // 棕
    @BindView(R.id.tv_yellow)
    TextView mTv_yellow; // 黄
    @BindView(R.id.tv_brownYellow)
    TextView mTv_brownYellow; // 棕黄
    @BindView(R.id.tv_grey)
    TextView mTv_grey; // 灰

    @BindView(R.id.tv_clay)
    TextView mTv_clay; // 黏
    @BindView(R.id.tv_loam)
    TextView mTv_loam; // 壤
    @BindView(R.id.tv_sand)
    TextView mTv_sand; // 沙

    @BindView(R.id.tv_granular)
    TextView mTv_granular; // 粒状
    @BindView(R.id.tv_blocky)
    TextView mTv_blocky; // 块状
    @BindView(R.id.tv_flaky)
    TextView mTv_flaky; // 片状

    @BindView(R.id.tv_dry)
    TextView mTv_dry; // 干
    @BindView(R.id.tv_moist)
    TextView mTv_moist; // 潮
    @BindView(R.id.tv_wet)
    TextView mTv_wet; // 湿

    @BindView(R.id.tv_loose)
    TextView mTv_loose; // 松散
    @BindView(R.id.tv_tight)
    TextView mTv_tight; // 紧实
    @BindView(R.id.tv_solid)
    TextView mTv_solid; // 坚实

    @BindView(R.id.rv_photo)
    RecyclerView mRv_photo;

    private Context mContext;
    private SoilSamplingPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_soil_sampling);

        ButterKnife.bind(this);

        mContext = SoilSamplingActivity.this;

        presenter = new SoilSamplingPresenter(mContext, this);

        presenter.initView();
    }

    @OnClick({R.id.tv_located, R.id.tv_sunny, R.id.tv_overcast, R.id.tv_rain, R.id.tv_wind,
            R.id.tv_serious, R.id.tv_moderate, R.id.tv_mild,
            R.id.tv_flatland, R.id.tv_mountain, R.id.tv_hills, R.id.tv_wetlands,
            R.id.tv_black, R.id.tv_brown, R.id.tv_yellow, R.id.tv_brownYellow, R.id.tv_grey,
            R.id.tv_clay, R.id.tv_loam, R.id.tv_sand,
            R.id.tv_granular, R.id.tv_blocky, R.id.tv_flaky,
            R.id.tv_dry, R.id.tv_moist, R.id.tv_wet,
            R.id.tv_loose, R.id.tv_tight, R.id.tv_solid,
            R.id.tv_submit})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.tv_located:
                break;

            // 气候条件
            case R.id.tv_sunny:
                presenter.setClimaticChecked(0);
                break;
            case R.id.tv_overcast:
                presenter.setClimaticChecked(1);
                break;
            case R.id.tv_rain:
                presenter.setClimaticChecked(2);
                break;
            case R.id.tv_wind:
                presenter.setClimaticChecked(3);
                break;

            // 利用程度
            case R.id.tv_serious:
                presenter.setDegreeChecked(0);
                break;
            case R.id.tv_moderate:
                presenter.setDegreeChecked(1);
                break;
            case R.id.tv_mild:
                presenter.setDegreeChecked(2);
                break;

            // 地形
            case R.id.tv_flatland:
                presenter.setTerrainChecked(0);
                break;
            case R.id.tv_mountain:
                presenter.setTerrainChecked(1);
                break;
            case R.id.tv_hills:
                presenter.setTerrainChecked(2);
                break;
            case R.id.tv_wetlands:
                presenter.setTerrainChecked(3);
                break;

            // 颜色
            case R.id.tv_black:
                presenter.setColorChecked(0);
                break;
            case R.id.tv_brown:
                presenter.setColorChecked(1);
                break;
            case R.id.tv_yellow:
                presenter.setColorChecked(2);
                break;
            case R.id.tv_brownYellow:
                presenter.setColorChecked(3);
                break;
            case R.id.tv_grey:
                presenter.setColorChecked(4);
                break;

            // 质地
            case R.id.tv_clay:
                presenter.setTextureChecked(0);
                break;
            case R.id.tv_loam:
                presenter.setTextureChecked(1);
                break;
            case R.id.tv_sand:
                presenter.setTextureChecked(2);
                break;

            // 结构
            case R.id.tv_granular:
                presenter.setStructureChecked(0);
                break;
            case R.id.tv_blocky:
                presenter.setStructureChecked(1);
                break;
            case R.id.tv_flaky:
                presenter.setStructureChecked(2);
                break;

            // 湿度
            case R.id.tv_dry:
                presenter.setHumidityChecked(0);
                break;
            case R.id.tv_moist:
                presenter.setHumidityChecked(1);
                break;
            case R.id.tv_wet:
                presenter.setHumidityChecked(2);
                break;

            // 松紧度
            case R.id.tv_loose:
                presenter.setElasticChecked(0);
                break;
            case R.id.tv_tight:
                presenter.setElasticChecked(1);
                break;
            case R.id.tv_solid:
                presenter.setElasticChecked(2);
                break;

            // 提交
            case R.id.tv_submit:
                break;
        }
    }

    @Override
    public EditText getEditTextCity() {
        return mEt_city;
    }

    @Override
    public EditText getEditTextLocation() {
        return mEt_location;
    }

    @Override
    public EditText getEditTextLon() {
        return mEt_lon;
    }

    @Override
    public EditText getEditTextLat() {
        return mEt_lat;
    }

    @Override
    public EditText getEditTextAltitude() {
        return mEt_altitude;
    }

    @Override
    public EditText getEditTextDate() {
        return mEt_date;
    }

    @Override
    public TextView getTextViewSunny() {
        return mTv_sunny;
    }

    @Override
    public TextView getTextViewOvercast() {
        return mTv_overcast;
    }

    @Override
    public TextView getTextViewRain() {
        return mTv_rain;
    }

    @Override
    public TextView getTextViewWind() {
        return mTv_wind;
    }

    @Override
    public EditText getEditTextGrasslandType() {
        return mEt_grasslandType;
    }

    @Override
    public TextView getTextViewSerious() {
        return mTv_serious;
    }

    @Override
    public TextView getTextViewModerate() {
        return mTv_moderate;
    }

    @Override
    public TextView getTextViewMild() {
        return mTv_mild;
    }

    @Override
    public EditText getEditTextDominant() {
        return mEt_dominant;
    }

    @Override
    public TextView getTextViewFlatland() {
        return mTv_flatland;
    }

    @Override
    public TextView getTextViewMountain() {
        return mTv_mountain;
    }

    @Override
    public TextView getTextViewHills() {
        return mTv_hills;
    }

    @Override
    public TextView getTextViewWetlands() {
        return mTv_wetlands;
    }

    @Override
    public EditText getEditTextSoilType() {
        return mEt_soilType;
    }

    @Override
    public EditText getEditTextProfileDepth() {
        return mEt_profileDepth;
    }

    @Override
    public TextView getTextViewBlack() {
        return mTv_black;
    }

    @Override
    public TextView getTextViewBrown() {
        return mTv_brown;
    }

    @Override
    public TextView getTextViewYellow() {
        return mTv_yellow;
    }

    @Override
    public TextView getTextViewBrownYellow() {
        return mTv_brownYellow;
    }

    @Override
    public TextView getTextViewGrey() {
        return mTv_grey;
    }

    @Override
    public TextView getTextViewClay() {
        return mTv_clay;
    }

    @Override
    public TextView getTextViewLoam() {
        return mTv_loam;
    }

    @Override
    public TextView getTextViewSand() {
        return mTv_sand;
    }

    @Override
    public TextView getTextViewGranular() {
        return mTv_granular;
    }

    @Override
    public TextView getTextViewBlocky() {
        return mTv_blocky;
    }

    @Override
    public TextView getTextViewFlaky() {
        return mTv_flaky;
    }

    @Override
    public TextView getTextViewDry() {
        return mTv_dry;
    }

    @Override
    public TextView getTextViewMoist() {
        return mTv_moist;
    }

    @Override
    public TextView getTextViewWet() {
        return mTv_wet;
    }

    @Override
    public TextView getTextViewLoose() {
        return mTv_loose;
    }

    @Override
    public TextView getTextViewTight() {
        return mTv_tight;
    }

    @Override
    public TextView getTextViewSolid() {
        return mTv_solid;
    }

    @Override
    public RecyclerView getRecyclerViewPhoto() {
        return mRv_photo;
    }

    @Override
    public void toCamera() {
        Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量，启动相机的关键
        startActivityForResult(openCameraIntent, 0); // 参数常量为自定义的request code, 在取返回结果时有用

        /*Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("image/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, 1);*/

        /*Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent, 1);*/
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
    }
}
