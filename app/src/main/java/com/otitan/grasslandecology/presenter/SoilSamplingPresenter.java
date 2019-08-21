package com.otitan.grasslandecology.presenter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.adapter.PhotoAdapter;
import com.otitan.grasslandecology.view.ISoilSampling;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sp on 2019/8/5.
 * 土壤采样
 */
public class SoilSamplingPresenter {

    private Context mContext;
    private ISoilSampling iSoilSampling;

    private EditText mEt_city;
    private EditText mEt_location;
    private EditText mEt_lon;
    private EditText mEt_lat;
    private EditText mEt_altitude;
    private EditText mEt_date;

    private TextView mTv_sunny;
    private TextView mTv_overcast;
    private TextView mTv_rain;
    private TextView mTv_wind;
    private List<TextView> climaticList = new ArrayList<>();
    private boolean isCheckedSunny = false;
    private boolean isCheckedOvercast = false;
    private boolean isCheckedRain = false;
    private boolean isCheckedWind = false;

    private EditText mEt_grasslandType;

    private TextView mTv_serious;
    private TextView mTv_moderate;
    private TextView mTv_mild;
    private List<TextView> degreeList = new ArrayList<>();
    private boolean isCheckedSerious = false;
    private boolean isCheckedModerate = false;
    private boolean isCheckedMild = false;

    private EditText mEt_dominant;

    private TextView mTv_flatland;
    private TextView mTv_mountain;
    private TextView mTv_hills;
    private TextView mTv_wetlands;
    private List<TextView> terrainList = new ArrayList<>();
    private boolean isCheckedFlatland = false;
    private boolean isCheckedMountain = false;
    private boolean isCheckedHills = false;
    private boolean isCheckedWetlands = false;

    private EditText mEt_soilType;
    private EditText mEt_profileDepth;

    private TextView mTv_black;
    private TextView mTv_brown;
    private TextView mTv_yellow;
    private TextView mTv_brownYellow;
    private TextView mTv_grey;
    private List<TextView> colorList = new ArrayList<>();
    private boolean isCheckedBlack = false;
    private boolean isCheckedBrown = false;
    private boolean isCheckedYellow = false;
    private boolean isCheckedBrownYellow = false;
    private boolean isCheckedGrey = false;

    private TextView mTv_clay;
    private TextView mTv_loam;
    private TextView mTv_sand;
    private List<TextView> textureList = new ArrayList<>();
    private boolean isCheckedClay = false;
    private boolean isCheckedLoam = false;
    private boolean isCheckedSand = false;

    private TextView mTv_granular;
    private TextView mTv_blocky;
    private TextView mTv_flaky;
    private List<TextView> structureList = new ArrayList<>();
    private boolean isCheckedGranular = false;
    private boolean isCheckedBlocky = false;
    private boolean isCheckedFlaky = false;

    private TextView mTv_dry;
    private TextView mTv_moist;
    private TextView mTv_wet;
    private List<TextView> humidityList = new ArrayList<>();
    private boolean isCheckedDry = false;
    private boolean isCheckedMoist = false;
    private boolean isCheckedWet = false;

    private TextView mTv_loose;
    private TextView mTv_tight;
    private TextView mTv_solid;
    private List<TextView> elasticList = new ArrayList<>();
    private boolean isCheckedLoose = false;
    private boolean isCheckedTight = false;
    private boolean isCheckedSolid = false;

    private RecyclerView mRv_photo;

    public SoilSamplingPresenter(Context context, ISoilSampling iSoilSampling) {
        mContext = context;
        this.iSoilSampling = iSoilSampling;
    }

    public void initView() {
        mEt_city = iSoilSampling.getEditTextCity();
        mEt_location = iSoilSampling.getEditTextLocation();
        mEt_lon = iSoilSampling.getEditTextLon();
        mEt_lat = iSoilSampling.getEditTextLat();
        mEt_altitude = iSoilSampling.getEditTextAltitude();
        mEt_date = iSoilSampling.getEditTextDate();

        mTv_sunny = iSoilSampling.getTextViewSunny();
        mTv_overcast = iSoilSampling.getTextViewOvercast();
        mTv_rain = iSoilSampling.getTextViewRain();
        mTv_wind = iSoilSampling.getTextViewWind();

        climaticList.add(mTv_sunny);
        climaticList.add(mTv_overcast);
        climaticList.add(mTv_rain);
        climaticList.add(mTv_wind);

        // 草原类型
        mEt_grasslandType = iSoilSampling.getEditTextGrasslandType();

        // 重度
        mTv_serious = iSoilSampling.getTextViewSerious();
        // 中度
        mTv_moderate = iSoilSampling.getTextViewModerate();
        // 轻度
        mTv_mild = iSoilSampling.getTextViewMild();

        degreeList.add(mTv_serious);
        degreeList.add(mTv_moderate);
        degreeList.add(mTv_mild);

        // 优势植物
        mEt_dominant = iSoilSampling.getEditTextDominant();

        // 平原
        mTv_flatland = iSoilSampling.getTextViewFlatland();
        // 山地
        mTv_mountain = iSoilSampling.getTextViewMountain();
        // 丘陵
        mTv_hills = iSoilSampling.getTextViewHills();
        // 湿地
        mTv_wetlands = iSoilSampling.getTextViewWetlands();

        terrainList.add(mTv_flatland);
        terrainList.add(mTv_mountain);
        terrainList.add(mTv_hills);
        terrainList.add(mTv_wetlands);

        // 土壤类型
        mEt_soilType = iSoilSampling.getEditTextSoilType();
        // 剖面深度
        mEt_profileDepth = iSoilSampling.getEditTextProfileDepth();

        // 黑
        mTv_black = iSoilSampling.getTextViewBlack();
        // 棕
        mTv_brown = iSoilSampling.getTextViewBrown();
        // 黄
        mTv_yellow = iSoilSampling.getTextViewYellow();
        // 棕黄
        mTv_brownYellow = iSoilSampling.getTextViewBrownYellow();
        // 灰
        mTv_grey = iSoilSampling.getTextViewGrey();

        colorList.add(mTv_black);
        colorList.add(mTv_brown);
        colorList.add(mTv_yellow);
        colorList.add(mTv_brownYellow);
        colorList.add(mTv_grey);

        // 黏
        mTv_clay = iSoilSampling.getTextViewClay();
        // 壤
        mTv_loam = iSoilSampling.getTextViewLoam();
        // 沙
        mTv_sand = iSoilSampling.getTextViewSand();

        textureList.add(mTv_clay);
        textureList.add(mTv_loam);
        textureList.add(mTv_sand);

        // 粒状
        mTv_granular = iSoilSampling.getTextViewGranular();
        // 块状
        mTv_blocky = iSoilSampling.getTextViewBlocky();
        // 片状
        mTv_flaky = iSoilSampling.getTextViewFlaky();

        structureList.add(mTv_granular);
        structureList.add(mTv_blocky);
        structureList.add(mTv_flaky);

        // 干
        mTv_dry = iSoilSampling.getTextViewDry();
        // 潮
        mTv_moist = iSoilSampling.getTextViewMoist();
        // 湿
        mTv_wet = iSoilSampling.getTextViewWet();

        humidityList.add(mTv_dry);
        humidityList.add(mTv_moist);
        humidityList.add(mTv_wet);

        // 松散
        mTv_loose = iSoilSampling.getTextViewLoose();
        // 紧实
        mTv_tight = iSoilSampling.getTextViewTight();
        // 坚实
        mTv_solid = iSoilSampling.getTextViewSolid();

        elasticList.add(mTv_loose);
        elasticList.add(mTv_tight);
        elasticList.add(mTv_solid);

        mRv_photo = iSoilSampling.getRecyclerViewPhoto();

        List<String> list = new ArrayList<>();

        mRv_photo.setLayoutManager(new LinearLayoutManager(mContext));
        mRv_photo.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.HORIZONTAL));
        PhotoAdapter photoAdapter = new PhotoAdapter(mContext, list);
        mRv_photo.setAdapter(photoAdapter);

        photoAdapter.setItemClickListener(new PhotoAdapter.MyItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                iSoilSampling.toCamera();
            }
        });
    }

    /**
     * 气候条件
     * @param i
     */
    @SuppressLint("NewApi")
    public void setClimaticChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedSunny) {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 0) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = false;
                } else {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 0) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = true;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = false;
                }
                break;
            case 1:
                if (isCheckedOvercast) {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 1) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = false;
                } else {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 1) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = true;
                    isCheckedRain = false;
                    isCheckedWind = false;
                }
                return;
            case 2:
                if (isCheckedRain) {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 2) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = false;
                } else {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 2) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = true;
                    isCheckedWind = false;
                }
                break;
            case 3:
                if (isCheckedWind) {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 3) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = false;
                } else {
                    for (int j = 0; j < climaticList.size(); j++) {
                        if (j == 3) {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            climaticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            climaticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSunny = false;

                    isCheckedOvercast = false;
                    isCheckedRain = false;
                    isCheckedWind = true;
                }
                break;
        }
    }

    /**
     * 利用程度
     * @param i
     */
    @SuppressLint("NewApi")
    public void setDegreeChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedSerious) {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 0) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = false;
                    isCheckedModerate = false;
                    isCheckedMild = false;
                } else {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 0) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = true;
                    isCheckedModerate = false;
                    isCheckedMild = false;
                }
                break;
            case 1:
                if (isCheckedModerate) {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 1) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = false;
                    isCheckedModerate = false;
                    isCheckedMild = false;
                } else {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 1) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = false;
                    isCheckedModerate = true;
                    isCheckedMild = false;
                }
                break;
            case 2:
                if (isCheckedMild) {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 2) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = false;
                    isCheckedModerate = false;
                    isCheckedMild = false;
                } else {
                    for (int j = 0; j < degreeList.size(); j++) {
                        if (j == 2) {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            degreeList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            degreeList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedSerious = false;
                    isCheckedModerate = false;
                    isCheckedMild = true;
                }
                break;
        }
    }

    /**
     * 地形
     * @param i
     */
    @SuppressLint("NewApi")
    public void setTerrainChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedFlatland) {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 0) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                } else {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 0) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = true;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                }
                break;
            case 1:
                if (isCheckedMountain) {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 1) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                } else {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 1) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = true;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                }
                break;
            case 2:
                if (isCheckedHills) {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 2) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                } else {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 2) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = true;
                    isCheckedWetlands = false;
                }
                break;
            case 3:
                if (isCheckedWetlands) {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 3) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = false;
                } else {
                    for (int j = 0; j < terrainList.size(); j++) {
                        if (j == 3) {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            terrainList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            terrainList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedFlatland = false;
                    isCheckedMountain = false;
                    isCheckedHills = false;
                    isCheckedWetlands = true;
                }
                break;
        }
    }

    /**
     * 颜色
     * @param i
     */
    @SuppressLint("NewApi")
    public void setColorChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedBlack) {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 0) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                } else {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 0) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = true;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                }
                break;
            case 1:
                if (isCheckedBrown) {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 1) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                } else {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 1) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = true;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                }
                break;
            case 2:
                if (isCheckedYellow) {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 2) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                } else {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 2) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = true;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                }
                break;
            case 3:
                if (isCheckedBrownYellow) {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 3) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                } else {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 3) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = true;
                    isCheckedGrey = false;
                }
                break;
            case 4:
                if (isCheckedGrey) {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 4) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = false;
                } else {
                    for (int j = 0; j < colorList.size(); j++) {
                        if (j == 4) {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            colorList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            colorList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedBlack = false;
                    isCheckedBrown = false;
                    isCheckedYellow = false;
                    isCheckedBrownYellow = false;
                    isCheckedGrey = true;
                }
                break;
        }
    }

    /**
     * 质地
     * @param i
     */
    @SuppressLint("NewApi")
    public void setTextureChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedClay) {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 0) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = false;
                    isCheckedLoam = false;
                    isCheckedSand = false;
                } else {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 0) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = true;
                    isCheckedLoam = false;
                    isCheckedSand = false;
                }
                break;
            case 1:
                if (isCheckedLoam) {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 1) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = false;
                    isCheckedLoam = false;
                    isCheckedSand = false;
                } else {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 1) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = false;
                    isCheckedLoam = true;
                    isCheckedSand = false;
                }
                break;
            case 2:
                if (isCheckedSand) {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 2) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = false;
                    isCheckedLoam = false;
                    isCheckedSand = false;
                } else {
                    for (int j = 0; j < textureList.size(); j++) {
                        if (j == 2) {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            textureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            textureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedClay = false;
                    isCheckedLoam = false;
                    isCheckedSand = true;
                }
                break;
        }
    }

    /**
     * 结构
     * @param i
     */
    @SuppressLint("NewApi")
    public void setStructureChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedGranular) {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 0) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = false;
                    isCheckedBlocky = false;
                    isCheckedFlaky = false;
                } else {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 0) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = true;
                    isCheckedBlocky = false;
                    isCheckedFlaky = false;
                }
                break;
            case 1:
                if (isCheckedBlocky) {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 1) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = false;
                    isCheckedBlocky = false;
                    isCheckedFlaky = false;
                } else {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 1) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = false;
                    isCheckedBlocky = true;
                    isCheckedFlaky = false;
                }
                break;
            case 2:
                if (isCheckedFlaky) {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 2) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = false;
                    isCheckedBlocky = false;
                    isCheckedFlaky = false;
                } else {
                    for (int j = 0; j < structureList.size(); j++) {
                        if (j == 2) {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            structureList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            structureList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedGranular = false;
                    isCheckedBlocky = false;
                    isCheckedFlaky = true;
                }
                break;
        }
    }

    /**
     * 湿度
     * @param i
     */
    @SuppressLint("NewApi")
    public void setHumidityChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedDry) {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 0) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = false;
                    isCheckedMoist = false;
                    isCheckedWet = false;
                } else {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 0) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = true;
                    isCheckedMoist = false;
                    isCheckedWet = false;
                }
                break;
            case 1:
                if (isCheckedMoist) {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 1) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = false;
                    isCheckedMoist = false;
                    isCheckedWet = false;
                } else {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 1) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = false;
                    isCheckedMoist = true;
                    isCheckedWet = false;
                }
                break;
            case 2:
                if (isCheckedWet) {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 2) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = false;
                    isCheckedMoist = false;
                    isCheckedWet = false;
                } else {
                    for (int j = 0; j < humidityList.size(); j++) {
                        if (j == 2) {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            humidityList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            humidityList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedDry = false;
                    isCheckedMoist = false;
                    isCheckedWet = true;
                }
                break;
        }
    }

    /**
     * 松紧度
     * @param i
     */
    @SuppressLint("NewApi")
    public void setElasticChecked(int i) {
        switch (i) {
            case 0:
                if (isCheckedLoose) {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 0) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = false;
                    isCheckedTight = false;
                    isCheckedSolid = false;
                } else {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 0) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = true;
                    isCheckedTight = false;
                    isCheckedSolid = false;
                }
                break;
            case 1:
                if (isCheckedTight) {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 1) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = false;
                    isCheckedTight = false;
                    isCheckedSolid = false;
                } else {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 1) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = false;
                    isCheckedTight = true;
                    isCheckedSolid = false;
                }
                break;
            case 2:
                if (isCheckedSolid) {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 2) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = false;
                    isCheckedTight = false;
                    isCheckedSolid = false;
                } else {
                    for (int j = 0; j < elasticList.size(); j++) {
                        if (j == 2) {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.white));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_press));
                        } else {
                            elasticList.get(j).setTextColor(mContext.getResources().getColor(R.color.grey_text));
                            elasticList.get(j).setBackground(mContext.getResources().getDrawable(R.drawable.bg_text_normal));
                        }
                    }

                    isCheckedLoose = false;
                    isCheckedTight = false;
                    isCheckedSolid = true;
                }
                break;
        }
    }
}
