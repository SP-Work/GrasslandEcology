package com.otitan.grasslandecology;

import android.annotation.SuppressLint;
import android.app.Application;
import android.content.Context;

import com.otitan.grasslandecology.bean.MyObjectBox;

import java.util.ArrayList;
import java.util.List;

import io.objectbox.BoxStore;
import io.objectbox.android.AndroidObjectBrowser;

/**
 * Created by sp on 2019/7/19.
 */
@SuppressLint("Registered")
public class MyApplication extends Application {

    private static Context instance;

    private static BoxStore boxStore;

    public static String APP_ID = "16857432";
    public static String API_KEY = "Kx7DF3yp9MSbXMei2qdo0V2l";
    public static String SECRET_KEY = "Eivepmnd1Yy6wV6WOK1GfzhPKPsYHyZg";

    public static List<Integer> imgList = new ArrayList<>();

    @Override
    public void onCreate() {
        super.onCreate();

        instance = this;

        boxStore = MyObjectBox.builder().androidContext(this).build();
        if (BuildConfig.DEBUG) {
            // 打开调试信息
            new AndroidObjectBrowser(boxStore).start(this);
        }

        imgList.add(R.drawable.banner1);
        imgList.add(R.drawable.banner2);
        imgList.add(R.drawable.banner3);
    }

    public static Context getInstance() {
        return instance;
    }

    public static BoxStore getBoxstore() {
        if (boxStore == null) {
            boxStore = MyObjectBox.builder().androidContext(instance).build();
        }
        return boxStore;
    }
}
