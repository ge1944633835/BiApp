package com.blockbi.app.ui.activities.account;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;

import com.blockbi.app.R;
import com.blockbi.app.ui.fragments.account.RegisterStepFourFragment;
import com.blockbi.app.ui.fragments.account.RegisterStepOneFragment;
import com.blockbi.app.ui.fragments.account.RegisterStepThreeFragment;
import com.blockbi.app.ui.fragments.account.RegisterStepTwoFragment;
import com.blockbi.app.helper.RegisterSwitchHelper;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import me.sunlight.sdk.common.app.Activity;

public class RegisterActivity extends Activity implements RegisterSwitchHelper {

    @BindView(R.id.register_vp)
    ViewPager mViewPager;

    FragmentPagerAdapter mAdapter;
    @BindView(R.id.register_img_point_one)
    ImageView mImgPointOne;
    @BindView(R.id.register_img_point_two)
    ImageView mImgPointTwo;
    @BindView(R.id.register_img_point_three)
    ImageView mImgPointThree;
    @BindView(R.id.register_img_point_four)
    ImageView mImgPointFour;

    private List<Fragment> mList = new ArrayList<>();

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_register;
    }

    @Override
    protected void initBefore() {
        super.initBefore();

        getTitleBar().setTitle("");
        getTitleBar().setLeftImageResource(R.mipmap.ic_up);
    }

    @Override
    protected void initWidget() {
        super.initWidget();

        mList.add(RegisterStepOneFragment.newInstance());
        mList.add(RegisterStepTwoFragment.newInstance());
        mList.add(RegisterStepThreeFragment.newInstance());
        mList.add(RegisterStepFourFragment.newInstance());


        mViewPager.setAdapter(mAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {

            @Override
            public int getCount() {
                return mList.size();
            }

            @Override
            public Fragment getItem(int position) {
                return mList.get(position);
            }

        });

    }

    @Override
    protected void initData() {
        super.initData();
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {

                    case 0:
                        mImgPointOne.setImageResource(R.mipmap.ic_register_point_one);
                        mImgPointTwo.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointThree.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointFour.setImageResource(R.mipmap.ic_register_point_normal);
                        break;

                    case 1:
                        mImgPointOne.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointTwo.setImageResource(R.mipmap.ic_register_point_two);
                        mImgPointThree.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointFour.setImageResource(R.mipmap.ic_register_point_normal);
                        break;

                    case 2:
                        mImgPointOne.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointTwo.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointThree.setImageResource(R.mipmap.ic_register_point_three);
                        mImgPointFour.setImageResource(R.mipmap.ic_register_point_normal);
                        break;

                    case 3:
                        mImgPointOne.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointTwo.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointThree.setImageResource(R.mipmap.ic_register_point_normal);
                        mImgPointFour.setImageResource(R.mipmap.ic_register_point_four);

                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }

    @Override
    public ViewPager getViewpager() {
        return this.mViewPager;
    }
}
