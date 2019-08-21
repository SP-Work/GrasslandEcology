package com.otitan.grasslandecology.view;

import android.support.v7.widget.RecyclerView;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by sp on 2019/7/25.
 * 植图识别
 */
public interface IPlantRecognition {

    ImageView getIVTest();

    TextView getTVResult();

    TextView getTVScore();

    TextView getTVDescription();

    RecyclerView getResultList();

    RecyclerView getPlantList();
}
