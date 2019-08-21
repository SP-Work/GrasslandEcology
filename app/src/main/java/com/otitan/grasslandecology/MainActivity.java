package com.otitan.grasslandecology;

import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.otitan.grasslandecology.adapter.MyFragmentPagerAdapter;
import com.otitan.grasslandecology.fragment.DataCollectionFragment;
import com.otitan.grasslandecology.fragment.EcologicalNavigationFragment;
import com.otitan.grasslandecology.fragment.HomeFragment;
import com.otitan.grasslandecology.fragment.PersonalCenterFragment;
import com.otitan.grasslandecology.fragment.PlantRecognitionFragment;
import com.otitan.grasslandecology.permission.PermissionsChecker;
import com.otitan.grasslandecology.util.ToastUtil;
import com.otitan.grasslandecology.view.NoScrollViewPager;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    @BindView(R.id.vp_main)
    NoScrollViewPager mVp_main;
    @BindView(R.id.rg_main)
    RadioGroup mRg_main;
    @BindView(R.id.rb_home)
    RadioButton mRb_home;
    @BindView(R.id.rb_dc)
    RadioButton mRb_dc;
    @BindView(R.id.rb_pr)
    RadioButton mRb_pr;
    @BindView(R.id.rb_en)
    RadioButton mRb_en;
    @BindView(R.id.rb_pc)
    RadioButton mRb_pc;

    /**动态检测权限*/
    private static final int REQUEST_CODE = 10000; // 权限请求码
    private String[] permissions = new String[] {
            android.Manifest.permission.READ_PHONE_STATE,
            android.Manifest.permission.WRITE_EXTERNAL_STORAGE,
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_NETWORK_STATE,
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_LOCATION_EXTRA_COMMANDS,
            android.Manifest.permission.CAMERA
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        PermissionsChecker permissionsChecker = new PermissionsChecker(this);
        if (permissionsChecker.lacksPermissions(permissions)) {
            ActivityCompat.requestPermissions(this, permissions, REQUEST_CODE);
        }

        initView();
    }

    private void initView() {
        List<Fragment> fmList = new ArrayList<>();
        fmList.add(new HomeFragment()); // 首页
        fmList.add(new DataCollectionFragment()); // 数据采集
        fmList.add(new PlantRecognitionFragment()); // 植图识别
        fmList.add(new EcologicalNavigationFragment()); // 生态导航
        fmList.add(new PersonalCenterFragment()); // 个人中心

        mVp_main.setScanScroll(true); // 设置ViewPager不可滑动
        mVp_main.addOnPageChangeListener(this); // ViewPager滑动监听
        mVp_main.setAdapter(new MyFragmentPagerAdapter(getSupportFragmentManager(), fmList));
        mRg_main.setOnCheckedChangeListener(this); // RadioGroup点击监听
    }

    @Override
    public void onPageScrolled(int i, float v, int i1) {

    }

    @Override
    public void onPageSelected(int i) {
        switch (i) {
            case 0:
                mRb_home.setChecked(true);
                break;
            case 1:
                mRb_dc.setChecked(true);
                break;
            case 2:
                mRb_pr.setChecked(true);
                break;
            case 3:
                mRb_en.setChecked(true);
                break;
            case 4:
                mRb_pc.setChecked(true);
                break;
        }
    }

    @Override
    public void onPageScrollStateChanged(int i) {

    }

    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
        switch (i) {
            case R.id.rb_home:
                mVp_main.setCurrentItem(0, false);
                break;
            case R.id.rb_dc:
                mVp_main.setCurrentItem(1, false);
                break;
            case R.id.rb_pr:
                mVp_main.setCurrentItem(2, false);
                break;
            case R.id.rb_en:
                mVp_main.setCurrentItem(3, false);
                break;
            case R.id.rb_pc:
                mVp_main.setCurrentItem(4, false);
                break;
        }
    }

    /**
     * 手机返回键监听
     */
    long firstTime = 0;
    @Override
    public void onBackPressed() {
        //super.onBackPressed();
        long secondTime = System.currentTimeMillis();
        if (secondTime - firstTime > 800) { // 两次点击间隔大于800毫秒，不退出
            ToastUtil.setToast(this, "再按一次退出程序");
            firstTime = secondTime; // 更新firstTime
        } else {
            System.exit(0); // 退出APP
        }
    }
}
