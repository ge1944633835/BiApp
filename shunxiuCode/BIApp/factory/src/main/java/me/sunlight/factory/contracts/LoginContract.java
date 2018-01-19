package me.sunlight.factory.contracts;


import me.sunlight.sdk.common.app.presenter.BaseContract;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/17
 *     desc   :
 *     version:
 * </pre>
 */

public interface LoginContract {

    interface View extends BaseContract.View<Presenter> {
        void loginSuccess();
    }

    interface Presenter extends BaseContract.Presenter {

        void doLogin(String name, String password);
    }

}
