package com.blockbi.app.ui.fragments.account;

import android.support.v4.view.ViewPager;
import android.widget.EditText;

import com.blockbi.app.R;
import com.blockbi.app.helper.RegisterSwitchHelper;

import butterknife.BindView;
import butterknife.OnClick;
import me.sunlight.sdk.common.app.Fragment;

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
}
