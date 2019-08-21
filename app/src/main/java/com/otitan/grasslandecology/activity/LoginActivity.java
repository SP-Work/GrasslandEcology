package com.otitan.grasslandecology.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.otitan.grasslandecology.MainActivity;
import com.otitan.grasslandecology.R;
import com.otitan.grasslandecology.util.ToastUtil;

import butterknife.ButterKnife;

/**
 * 登录
 */
public class LoginActivity extends AppCompatActivity {

    private Context mContext;

    private SharedPreferences MSP;

    private boolean isLogin = true;

    private EditText mEt_user;
    private EditText mEt_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);

        mContext = LoginActivity.this;

        MSP = this.getSharedPreferences("MSP", 0);

        initView();
    }

    private void initView() {
        final String username = MSP.getString("USERNAME", "").trim();
        final String password = MSP.getString("PASSWORD", "").trim();

//        signIn(username, password);

        new Handler().postDelayed(new Runnable() {
            public void run() {
                /*if (!isLogin) {
                    showPopupWindow(username, password);
                }*/
                showPopupWindow(username, password);
            }
        }, 3000);
    }

    private void showPopupWindow(String user, String pass) {
        View inflate = LayoutInflater.from(mContext).inflate(R.layout.pop_login, null);
        PopupWindow popupWindow = new PopupWindow(inflate, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        mEt_user = inflate.findViewById(R.id.et_user);
        mEt_pass = inflate.findViewById(R.id.et_pass);
        TextView tv_login = inflate.findViewById(R.id.tv_login);
        TextView tv_registered = inflate.findViewById(R.id.tv_registered);
        TextView tv_forget = inflate.findViewById(R.id.tv_forget);

        mEt_user.setText(user);
        mEt_pass.setText(pass);

        tv_login.setOnClickListener(new MyClickListener());
        tv_registered.setOnClickListener(new MyClickListener());
        tv_forget.setOnClickListener(new MyClickListener());

        popupWindow.setTouchable(true);
        popupWindow.setFocusable(true);
        popupWindow.setAnimationStyle(R.style.pop_anim);
        popupWindow.showAtLocation(inflate, Gravity.BOTTOM, 0, 0);
    }

    private class MyClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.tv_login:
                    String user = mEt_user.getText().toString().trim();
                    String pass = mEt_pass.getText().toString().trim();
                    if (user.isEmpty()) {
                        ToastUtil.setToast(mContext, "请输入用户名");
                    } else if (pass.isEmpty()) {
                        ToastUtil.setToast(mContext, "请输入密码");
                    } else {
                        signIn(user, pass);
                    }
                    break;
                case R.id.tv_registered:
                    break;
                case R.id.tv_forget:
                    break;
            }
        }
    }

    private void signIn(String user, String pass) {
        if (user.equals("admin") && pass.equals("123456")) {
            startActivity(new Intent(mContext, MainActivity.class));

            MSP.edit().putString("USERNAME", user).apply();
            MSP.edit().putString("PASSWORD", pass).apply();

            isLogin = true;
            finish();
        } else {
            ToastUtil.setToast(mContext, "用户名密码不正确");
            isLogin = false;
        }
    }
}
