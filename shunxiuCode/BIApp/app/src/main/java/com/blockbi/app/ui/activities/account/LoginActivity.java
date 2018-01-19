package com.blockbi.app.ui.activities.account;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blockbi.app.HomeActivity;
import com.blockbi.app.R;

import butterknife.BindView;
import butterknife.OnClick;
import me.sunlight.sdk.common.app.Activity;

public class LoginActivity extends Activity {

    @BindView(R.id.login_et_account)
    EditText mEtAccount;
    @BindView(R.id.login_et_password)
    EditText mEtPassword;
    @BindView(R.id.login_btn_action)
    Button mBtnAction;
    @BindView(R.id.login_tv_register)
    TextView mTvRegister;
    @BindView(R.id.login_tv_forget)
    TextView mTvForget;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        hideTitleBar();
    }

    @OnClick({R.id.login_btn_action, R.id.login_tv_register, R.id.login_tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn_action:
                HomeActivity.runActivity(mContext, HomeActivity.class);
                finish();
                break;
            case R.id.login_tv_register:
                RegisterActivity.runActivity(mContext, RegisterActivity.class);
                break;
            case R.id.login_tv_forget:
                break;
        }
    }
}
