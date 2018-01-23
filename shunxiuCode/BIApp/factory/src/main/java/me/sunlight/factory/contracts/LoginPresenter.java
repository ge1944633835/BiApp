package me.sunlight.factory.contracts;

import android.text.TextUtils;

import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;
import com.orhanobut.logger.Logger;

import me.sunlight.factory.R;
import me.sunlight.sdk.common.app.Application;
import me.sunlight.sdk.common.app.presenter.BasePresenter;
import me.sunlight.sdk.common.network.api.Urls;
import me.sunlight.sdk.common.network.callback.CommonStringCallback;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/17
 *     desc   :
 *     version:
 * </pre>
 */

public class LoginPresenter extends BasePresenter<LoginContract.View> implements LoginContract.Presenter {

    public LoginPresenter(LoginContract.View view) {
        super(view);
    }

    @Override
    public void doLogin(String name, String password) {

        if (TextUtils.isEmpty(name) || TextUtils.isEmpty(password)) {
            Application.showToast(R.string.data_account_login_invalid_parameter, Application.TOAST_ERROR);
            return;
        }
        OkGo.<String>post(Urls.loginUrl)
                .params("username", name)
                .params("password", password)
                .execute(new CommonStringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        Logger.e(response.body());

                        getView().loginSuccess();
                    }
                });
    }
}
