package com.blockbi.app.ui.activities.account;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.blockbi.app.HomeActivity;
import com.blockbi.app.R;

import butterknife.BindView;
import butterknife.OnClick;
import me.sunlight.factory.contracts.LoginContract;
import me.sunlight.factory.contracts.LoginPresenter;
import me.sunlight.sdk.common.app.mvp.PresenterActivity;
import me.sunlight.sdk.common.util.StatusBarUtil;

public class LoginActivity extends PresenterActivity<LoginContract.Presenter> implements LoginContract.View {

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
    public LoginContract.Presenter initPresenter() {
        return new LoginPresenter(this);
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        hideTitleBar();
        StatusBarUtil.setColor(this, Color.parseColor("#000000"));
    }


    @OnClick({R.id.login_btn_action, R.id.login_tv_register, R.id.login_tv_forget})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.login_btn_action:
                String account = mEtAccount.getText().toString();
                String password = mEtPassword.getText().toString();
                mPresenter.doLogin(account, password);
                break;
            case R.id.login_tv_register:
                RegisterActivity.runActivity(mContext, RegisterActivity.class);
                break;
            case R.id.login_tv_forget:
                // TODO: 2018/1/23  忘记密码
                break;
        }
    }


    @Override
    public void loginSuccess() {
        HomeActivity.runActivity(mContext, HomeActivity.class);
    }

}
