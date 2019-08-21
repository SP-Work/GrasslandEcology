package com.otitan.grasslandecology.view;

import android.support.v7.widget.RecyclerView;
import android.widget.EditText;
import android.widget.TextView;

/**
 * Created by sp on 2019/8/5.
 * 土壤采样
 */
public interface ISoilSampling {

    EditText getEditTextCity();

    EditText getEditTextLocation();

    EditText getEditTextLon();

    EditText getEditTextLat();

    EditText getEditTextAltitude();

    EditText getEditTextDate();

    TextView getTextViewSunny();

    TextView getTextViewOvercast();

    TextView getTextViewRain();

    TextView getTextViewWind();

    EditText getEditTextGrasslandType(); // 草原类型

    TextView getTextViewSerious(); // 重度

    TextView getTextViewModerate(); // 中度

    TextView getTextViewMild(); // 轻度

    EditText getEditTextDominant(); // 优势植物

    TextView getTextViewFlatland(); // 平原

    TextView getTextViewMountain(); // 山地

    TextView getTextViewHills(); // 丘陵

    TextView getTextViewWetlands(); // 湿地

    EditText getEditTextSoilType(); // 土壤类型

    EditText getEditTextProfileDepth(); // 剖面深度

    TextView getTextViewBlack(); // 黑

    TextView getTextViewBrown(); // 棕

    TextView getTextViewYellow(); // 黄

    TextView getTextViewBrownYellow(); // 棕黄

    TextView getTextViewGrey(); // 灰

    TextView getTextViewClay(); // 黏

    TextView getTextViewLoam(); // 壤

    TextView getTextViewSand(); // 沙

    TextView getTextViewGranular(); // 粒状

    TextView getTextViewBlocky(); // 块状

    TextView getTextViewFlaky(); // 片状

    TextView getTextViewDry(); // 干

    TextView getTextViewMoist(); // 潮

    TextView getTextViewWet(); // 湿

    TextView getTextViewLoose(); // 松散

    TextView getTextViewTight(); // 紧实

    TextView getTextViewSolid(); // 坚实

    RecyclerView getRecyclerViewPhoto();

    void toCamera();
}
