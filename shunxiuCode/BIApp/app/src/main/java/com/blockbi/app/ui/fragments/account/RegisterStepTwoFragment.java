package com.blockbi.app.ui.fragments.account;

import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.widget.EditText;
import android.widget.TextView;

import com.blockbi.app.App;
import com.blockbi.app.R;
import com.blockbi.app.helper.RegisterSwitchHelper;
import com.lzy.okgo.OkGo;
import com.lzy.okgo.model.Response;

import butterknife.BindView;
import butterknife.OnClick;
import me.sunlight.sdk.common.app.Application;
import me.sunlight.sdk.common.app.Fragment;
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
public class RegisterStepTwoFragment extends Fragment {

    @BindView(R.id.fragment_register_et_phone)
    EditText metPhone;

    @BindView(R.id.fragment_register_two_tv_wrong)
    TextView mTvWrong;


    public static RegisterStepTwoFragment newInstance() {
        RegisterStepTwoFragment fragment = new RegisterStepTwoFragment();
        return fragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register_step_two;
    }


    @OnClick(R.id.fragment_register_img_next)
    public void next() {

        RegisterSwitchHelper helper = (RegisterSwitchHelper) getContext();
        ViewPager viewpager = helper.getViewpager();

        viewpager.setCurrentItem(2);

    }

    @OnClick(R.id.fragment_register_two_tv_resend)
    public void send() {
        String phone = metPhone.getText().toString();
        if (TextUtils.isEmpty(phone)) {
            Application.showToast(R.string.data_account_send_phone_empty, Application.TOAST_ERROR);
            return;
        }
        OkGo.<String>post(Urls.sendCodeUrl)
                .params("means", phone)
                .execute(new CommonStringCallback() {
                    @Override
                    public void onSuccess(Response<String> response) {
                        App.showToast(R.string.data_account_send_phone_success,Application.TOAST_SUCESS);
                    }
                });

    }

}
