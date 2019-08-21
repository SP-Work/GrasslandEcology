package com.otitan.grasslandecology.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.baidu.aip.ocr.AipOcr;
import com.google.gson.Gson;
import com.otitan.grasslandecology.MyApplication;
import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.activity.SoilSamplingActivity;
import com.otitan.grasslandecology.bean.BaikeError;
import com.otitan.grasslandecology.bean.BaikeText;
import com.otitan.grasslandecology.dialog.LoadingDialog;
import com.otitan.grasslandecology.presenter.DataCollectionPresenter;
import com.otitan.grasslandecology.util.FileUtil;
import com.otitan.grasslandecology.util.PicConversionUtil;
import com.otitan.grasslandecology.view.IDataCollection;
import com.youth.banner.Banner;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by sp on 2019/7/18.
 * 数据采集
 */
public class DataCollectionFragment extends BaseLazyFragment implements IDataCollection {

    @BindView(R.id.bn_top)
    Banner mBn_top;
    @BindView(R.id.tv_close)
    TextView mTv_close;
    @BindView(R.id.ll_template)
    LinearLayout mLl_template;

    @BindView(R.id.tv_result)
    TextView mTv_result;

    private String APP_ID;
    private String API_KEY;
    private String SECRET_KEY;

    private Context mContext;
    private DataCollectionPresenter presenter;

    private LoadingDialog loadingDialog;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View inflate = inflater.inflate(R.layout.fragment_data_collection, null);
        ButterKnife.bind(this, inflate);

        mContext = DataCollectionFragment.this.getContext();

        presenter = new DataCollectionPresenter(mContext, this);

        return inflate;
    }

    @Override
    public void onLazyLoad() {
        presenter.initView();

        initView();
    }

    private void initView() {
        APP_ID = MyApplication.APP_ID;
        API_KEY = MyApplication.API_KEY;
        SECRET_KEY = MyApplication.SECRET_KEY;

        loadingDialog = new LoadingDialog(mContext, R.style.dialog_normal);
    }

    @OnClick({R.id.tv_test, R.id.tv_test2, R.id.tv_close, R.id.tv_specimen, R.id.tv_soil, R.id.tv_area, R.id.tv_quadrat, R.id.tv_seed, R.id.tv_custom})
    public void myClick(View view) {
        switch (view.getId()) {
            case R.id.tv_test:
                Intent openCameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量，启动相机的关键
                startActivityForResult(openCameraIntent, 0); // 参数常量为自定义的request code, 在取返回结果时有用
                break;
            case R.id.tv_test2:
                /*Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                intent.addCategory(Intent.CATEGORY_OPENABLE);
                startActivityForResult(intent, 1);*/

                /*Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setType("image/*");
                startActivityForResult(intent, 1);*/
                break;

            case R.id.tv_close:
                if (mTv_close.getText().toString().contains("收起")) {
                    mTv_close.setText("打开");
                    mLl_template.setVisibility(View.GONE);
                } else {
                    mTv_close.setText("收起");
                    mLl_template.setVisibility(View.VISIBLE);
                }
                break;
            case R.id.tv_specimen:
                break;
            case R.id.tv_soil:
                startActivity(new Intent(mContext, SoilSamplingActivity.class));
                break;
            case R.id.tv_area:
                break;
            case R.id.tv_quadrat:
                break;
            case R.id.tv_seed:
                break;
            case R.id.tv_custom:
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE); //系统常量，启动相机的关键
                startActivityForResult(intent, 0); // 参数常量为自定义的request code, 在取返回结果时有用
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        loadingDialog.show();

        if (requestCode == 0 && data != null) {
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            byte[] bitmapByte = FileUtil.getBitmapByte(bitmap);

            getEncyclopediaInfo(bitmapByte);
        }

        if (requestCode == 1 && data != null) {
            String realPath = PicConversionUtil.getRealPathFromUri(mContext, data.getData());
            Bitmap bitmap = PicConversionUtil.getBitmapFromRealPath(realPath);
            byte[] bitmapByte = FileUtil.getBitmapByte(bitmap);

            getEncyclopediaInfo(bitmapByte);
        }
    }

    private void getEncyclopediaInfo(final byte[] bytes) {
        final AipOcr client = new AipOcr(APP_ID, API_KEY, SECRET_KEY);
        client.setConnectionTimeoutInMillis(2000);
        client.setSocketTimeoutInMillis(60000);
        final HashMap<String, String> options = new HashMap<>();
        options.put("baike_num", "5");

        new Thread(new Runnable() {
            @Override
            public void run() {
                final JSONObject res = client.basicGeneral(bytes, options);
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
                        BaikeText baikeText = new Gson().fromJson(result, BaikeText.class);
                        String btResult = "";
                        for (int i = 0; i < baikeText.getWords_result_num(); i++) {
                            btResult = btResult + baikeText.getWords_result().get(i).getWords() + "\n";
                        }
                        mTv_result.setText(btResult);
                    }
                    loadingDialog.dismiss();
                    break;
                default:
                    break;
            }
            return false;
        }
    });

    @Override
    public Banner getBanner() {
        return mBn_top;
    }
}
