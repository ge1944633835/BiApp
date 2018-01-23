package com.blockbi.app.ui.activities;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

import com.blockbi.app.HomeActivity;
import com.blockbi.app.R;

import cn.bingoogolapple.bgabanner.BGABanner;
import me.sunlight.sdk.common.util.RxSPUtils;


/**
 * 引导页
 */
public class GuideActivity extends AppCompatActivity {

    private BGABanner mBanner;
    private Context mContext = this;

    private static final String INSTALL_KEY = "INSTALL_KEY";

    private Button mButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        /**
         *  先判断是不是第一次启动，如果不是，直接跳过
         */
        if (!isFirstInstall()) {
            HomeActivity.runActivity(mContext, HomeActivity.class);
            finish();
        }
        //取消标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        //取消状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_guide);
        mBanner = findViewById(R.id.guide_banner);
        mButton = findViewById(R.id.btn_guide_enter);

        mBanner.setData(R.mipmap.ic_guide_one, R.mipmap.ic_guide_two, R.mipmap.ic_guide_three);
        mBanner.setEnterSkipViewIdAndDelegate(R.id.btn_guide_enter, 0, () -> {
            HomeActivity.runActivity(mContext, HomeActivity.class);
            finish();
        });

        mBanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                if (position == 2) {
                    mButton.setVisibility(View.VISIBLE);
                } else {
                    mButton.setVisibility(View.INVISIBLE);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    /**
     * 判断是否第一次打开应用
     *
     * @return true 是的，反之 不是
     */
    private boolean isFirstInstall() {
        if (RxSPUtils.getString(mContext, INSTALL_KEY).isEmpty()) {
            RxSPUtils.putString(mContext, INSTALL_KEY, "IsInstall");
            return true;
        }
        return false;
    }
}
