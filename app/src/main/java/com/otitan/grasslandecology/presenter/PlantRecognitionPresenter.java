package com.otitan.grasslandecology.presenter;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Handler;
import android.os.Message;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.baidu.aip.imageclassify.AipImageClassify;
import com.google.gson.Gson;
import com.otitan.grasslandecology.MyApplication;
import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.adapter.BaikePlantAdapter;
import com.otitan.grasslandecology.adapter.PlantHistoryAdapter;
import com.otitan.grasslandecology.bean.BaikeError;
import com.otitan.grasslandecology.bean.BaikePlant;
import com.otitan.grasslandecology.bean.PicBitmap;
import com.otitan.grasslandecology.util.FileUtil;
import com.otitan.grasslandecology.util.NetworkUtil;
import com.otitan.grasslandecology.util.PicConversionUtil;
import com.otitan.grasslandecology.view.IPlantRecognition;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;

import butterknife.BindView;
import io.objectbox.Box;

/**
 * Created by sp on 2019/7/25.
 * 植图识别
 */
public class PlantRecognitionPresenter {

    private Context mContext;
    private IPlantRecognition iPlantRecognition;

    private String APP_ID;
    private String API_KEY;
    private String SECRET_KEY;

    private ImageView mIv_plant;
    private TextView mTv_result;
    private TextView mTv_score;
    private TextView mTv_description;
    private RecyclerView mRv_result;
    private RecyclerView mRv_plant;

    public PlantRecognitionPresenter(Context context, IPlantRecognition iPlantRecognition) {
        mContext = context;
        this.iPlantRecognition = iPlantRecognition;
    }

    public void initView() {
        APP_ID = MyApplication.APP_ID;
        API_KEY = MyApplication.API_KEY;
        SECRET_KEY = MyApplication.SECRET_KEY;

        mIv_plant = iPlantRecognition.getIVTest();
        mTv_result = iPlantRecognition.getTVResult();
        mTv_score = iPlantRecognition.getTVScore();
        mTv_description = iPlantRecognition.getTVDescription();
        mRv_result = iPlantRecognition.getResultList();
        mRv_plant = iPlantRecognition.getPlantList();
    }

    public void getBitmapByte(Bitmap bitmap) {
        mIv_plant.setImageBitmap(bitmap);
        byte[] bitmapByte = FileUtil.getBitmapByte(bitmap);

        if (NetworkUtil.isNetworkAvailable(mContext)) {
            getEncyclopediaInfo(bitmapByte);

            /*mIv_plant.setVisibility(View.VISIBLE);
            mRv_result.setVisibility(View.VISIBLE);
            mRv_plant.setVisibility(View.GONE);*/
        } else {
            /*mIv_plant.setVisibility(View.GONE);
            mRv_result.setVisibility(View.GONE);
            mRv_plant.setVisibility(View.VISIBLE);*/
        }

//        intoHistory(bitmap);
    }

    private void getEncyclopediaInfo(final byte[] bytes) {
        final AipImageClassify aipImageClassify = new AipImageClassify(APP_ID, API_KEY, SECRET_KEY);
        aipImageClassify.setConnectionTimeoutInMillis(2000);
        aipImageClassify.setSocketTimeoutInMillis(60000);
        final HashMap<String, String> options = new HashMap<>();
        options.put("baike_num", "5");

        new Thread(new Runnable() {
            @Override
            public void run() {
                final JSONObject res = aipImageClassify.plantDetect(bytes, options);
                try {
                    Log.v("result", res.toString(2));

                    Message message = new Message();
                    message.what = 0;
                    message.obj = res.toString(2);
                    mHandler.sendMessage(message);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private Handler mHandler = new Handler(new Handler.Callback() {
        @Override
        public boolean handleMessage(Message message) {
            switch (message.what) {
                case 0:
                    String result = message.obj.toString();

                    if (result.contains("error_msg")) {
                        BaikeError error = new Gson().fromJson(result, BaikeError.class);
                        mTv_result.setText(error.getError_msg());
                    } else {
                        BaikePlant baikePlant = new Gson().fromJson(result, BaikePlant.class);
                        mRv_result.setLayoutManager(new LinearLayoutManager(mContext));
                        mRv_result.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
                        BaikePlantAdapter baikePlantAdapter = new BaikePlantAdapter(mContext, baikePlant.getResult());
                        mRv_result.setAdapter(baikePlantAdapter);

                        mTv_result.setText(baikePlant.getResult().get(0).getName());
                        String score = String.valueOf(baikePlant.getResult().get(0).getScore() * 100).substring(0, 2);
                        mTv_score.setText("相似度: " + score + "%");
                        mTv_description.setText(baikePlant.getResult().get(0).getBaike_info().getDescription());
                    }
                    break;
                default:
                    break;
            }
            return false;
        }
    });

    private void intoHistory(Bitmap bitmap) {
        PicBitmap picBitmap = new PicBitmap();
        picBitmap.setBitmap(PicConversionUtil.bitmapToString(bitmap));
        Box<PicBitmap> picBitmapBox = MyApplication.getBoxstore().boxFor(PicBitmap.class);
        picBitmapBox.put(picBitmap);

        List<PicBitmap> allList = picBitmapBox.getAll();

        GridLayoutManager gridLayoutManager = new GridLayoutManager(mContext,2);
        mRv_plant.setLayoutManager(gridLayoutManager);
        mRv_plant.setHasFixedSize(true);
        mRv_plant.addItemDecoration(new DividerItemDecoration(mContext, DividerItemDecoration.VERTICAL));
        PlantHistoryAdapter plantAdapter = new PlantHistoryAdapter(mContext, allList);
        mRv_plant.setAdapter(plantAdapter);
    }

    public void showHistory() {
        mIv_plant.setVisibility(View.GONE);
        mRv_result.setVisibility(View.GONE);
        mRv_plant.setVisibility(View.VISIBLE);
    }
}
