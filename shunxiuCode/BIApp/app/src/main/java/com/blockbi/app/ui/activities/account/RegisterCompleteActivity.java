package com.blockbi.app.ui.activities.account;

import com.blockbi.app.HomeActivity;
import com.blockbi.app.R;

import butterknife.OnClick;
import me.sunlight.sdk.common.app.Activity;

public class RegisterCompleteActivity extends Activity {


    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_register_complete;
    }


    @OnClick(R.id.register_tv_complete)
    public void skip(){

        HomeActivity.runActivity(mContext,HomeActivity.class);
        finish();

    }
}
