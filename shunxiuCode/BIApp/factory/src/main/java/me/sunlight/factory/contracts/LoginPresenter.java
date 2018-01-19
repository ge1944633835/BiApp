package me.sunlight.factory.contracts;

import android.text.TextUtils;

import me.sunlight.sdk.common.app.presenter.BasePresenter;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/17
 *     desc   :
 *     version:
 * </pre>
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements  LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void doLogin(String name, String password) {
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(password)){
            getView().loginSuccess();
        }else {
        }
    }

    @Override
    public void start() {

    }

    @Override
    public void destroy() {

    }
}
