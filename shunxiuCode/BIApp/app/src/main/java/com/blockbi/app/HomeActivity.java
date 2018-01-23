package com.blockbi.app;

import android.animation.Animator;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnticipateOvershootInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.blockbi.app.ui.activities.account.LoginActivity;
import com.blockbi.app.ui.fragments.home.HomeMenuPageOneFragment;
import com.blockbi.app.ui.widget.MenuViewPager;

import net.qiujuer.genius.ui.widget.FloatActionButton;

import java.util.Locale;

import butterknife.BindView;
import butterknife.OnClick;
import me.sunlight.sdk.common.app.Activity;
import me.sunlight.sdk.common.util.AppUtil;
import me.sunlight.sdk.common.util.Fglass;
import me.sunlight.sdk.common.widget.bottombar.tab.BottomTab;
import me.sunlight.sdk.common.widget.bottombar.tab.TabModel;
import me.sunlight.sdk.common.widget.recycler.RecyclerAdapter;
import me.sunlight.sdk.common.widget.titlebar.CommonTitleBar;

public class HomeActivity extends Activity {

    @BindView(R.id.drawer_layout)
    DrawerLayout mDrawerLayout;

    @BindView(R.id.home_menu_vp)
    MenuViewPager mViewPager;
    private FragmentPagerAdapter mPagerAdapter;

    @BindView(R.id.home_menu_img_indicate_one)
    ImageView mIndicateOne;
    @BindView(R.id.home_menu_img_indicate_two)
    ImageView mIndicateTwo;
    @BindView(R.id.home_menu_img_indicate_three)
    ImageView mIndicateThree;

    @BindView(R.id.home_title_bar)
    CommonTitleBar mTitleBar;

    @BindView(R.id.bottomTab)
    BottomTab mBottomtab;

    @BindView(R.id.home_action_btn)
    FloatActionButton mAction;
    @BindView(R.id.ll_pop_menu)
    LinearLayout mPopmenu;

    @BindView(R.id.home_view_shade)
    View shade;

    @BindView(R.id.home_fl_container)
    FrameLayout mContainer;

    @BindView(R.id.home_recycler)
    RecyclerView mRecyclerView;

    private RecyclerAdapter<String> mAdapter;

    private PopupWindow mPopupWindow;


    private boolean recover = true;

    @Override
    protected int getContentLayoutId() {
        return R.layout.activity_home;
    }

    @Override
    protected void initBefore() {
        super.initBefore();
        hideTitleBar();

        mTitleBar.setLeftImageResource(R.mipmap.ic_home_left_menu);
        mTitleBar.setDividerColor(Color.parseColor("#ececec"));
        mTitleBar.setDividerHeight(2);
        mTitleBar.setLeftClickListener(view -> mDrawerLayout.openDrawer(GravityCompat.START));
        mTitleBar.addAction(new CommonTitleBar.ImageAction(R.mipmap.ic_search) {
            @Override
            public void performAction(View view) {
                App.showToast("搜索");
            }
        }, 0);
        mTitleBar.addAction(new CommonTitleBar.ImageAction(R.mipmap.ic_message) {
            @Override
            public void performAction(View view) {
                App.showToast("消息列表");
            }
        }, 1);


        mBottomtab.initTab(R.color.black_alpha_48, R.color.black);
        mBottomtab
                .addTab(new TabModel.Builder()
                        .addTabText(getResources().getString(R.string.label_tab_top))
                        .addTabNormalIcon(R.mipmap.ic_top_normal)
                        .addTabSelectedIcon(R.mipmap.ic_top_pressed)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText(getResources().getString(R.string.label_tab_chat))
                        .addTabNormalIcon(R.mipmap.ic_chat_nomal)
                        .addTabSelectedIcon(R.mipmap.ic_chat_nomal)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText("")
                        .addTabNormalIcon(-1)
                        .addTabSelectedIcon(-1)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText(getResources().getString(R.string.label_tab_folder))
                        .addTabNormalIcon(R.mipmap.ic_folder_normal)
                        .addTabSelectedIcon(R.mipmap.ic_folder_normal)
                        .build())
                .addTab(new TabModel.Builder()
                        .addTabText(getResources().getString(R.string.label_tab_mission))
                        .addTabNormalIcon(R.mipmap.ic_mission_normal)
                        .addTabSelectedIcon(R.mipmap.ic_mission_normal)
                        .build());
    }

    @Override
    protected void initWidget() {
        super.initWidget();
        mRecyclerView.setLayoutManager(new LinearLayoutManager(mContext));
        mRecyclerView.setAdapter(mAdapter = new RecyclerAdapter<String>() {
            @Override
            protected int getItemViewType(int position, String s) {
                return R.layout.item_home_rlist;
            }

            @Override
            protected ViewHolder<String> onCreateViewHolder(View root, int viewType) {
                return new ItemHolder(root);
            }
        });

        View view = LayoutInflater.from(mContext).inflate(R.layout.layout_home_pop, null);
        mPopupWindow = new PopupWindow(view, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

        // 设置侧边栏的viewpager
        mViewPager.setAdapter(mPagerAdapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return new HomeMenuPageOneFragment();
            }

            @Override
            public int getCount() {
                return 3;
            }
        });
        mViewPager.setPageSize(3);

        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        mIndicateOne.setImageResource(R.mipmap.ic_indicate_white);
                        mIndicateTwo.setImageResource(R.mipmap.ic_indicate_gray);
                        mIndicateThree.setImageResource(R.mipmap.ic_indicate_gray);
                        break;
                    case 1:
                        mIndicateOne.setImageResource(R.mipmap.ic_indicate_gray);
                        mIndicateTwo.setImageResource(R.mipmap.ic_indicate_white);
                        mIndicateThree.setImageResource(R.mipmap.ic_indicate_gray);
                        break;
                    case 2:
                        mIndicateOne.setImageResource(R.mipmap.ic_indicate_gray);
                        mIndicateTwo.setImageResource(R.mipmap.ic_indicate_gray);
                        mIndicateThree.setImageResource(R.mipmap.ic_indicate_white);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    class ItemHolder extends RecyclerAdapter.ViewHolder<String> {
        @BindView(R.id.item_tv_txt)
        TextView txt;

        public ItemHolder(View itemView) {
            super(itemView);
        }

        @Override
        protected void onBind(String s) {
            txt.setText(s);
        }
    }


    @Override
    protected void initData() {
        super.initData();
        mAdapter.add("123", "hehe", "ssdada", "dsda", "werr", "hehhe", "ssdada", "dsda", "werr");
    }



    @OnClick(R.id.home_action_btn)
    public void action() {

        // 对浮动按钮进行隐藏与显示的动画
        float transY = 0; // 偏移量
        float rotation = recover ? 45 : 0; // 旋转的角度

        // 开始动画
        // 旋转，Y轴位移，弹性差值器，时间
        mAction.animate()
                .rotation(rotation)
                .translationY(transY)
                .setInterpolator(new AnticipateOvershootInterpolator(1))
                .setDuration(480)
                .setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animator) {
                        if (recover) {
                            Fglass.blur(mContainer, shade, 2, 8);
                            int[] location = new int[2];
                            mAction.getLocationOnScreen(location);
                            mPopupWindow.showAtLocation(mAction, Gravity.BOTTOM,
                                    0, AppUtil.dip2px(mContext, 52 + 26 + 52));
                        } else {
                            shade.setBackgroundColor(Color.parseColor("#00ffffff"));
                            mPopupWindow.dismiss();
                        }
                        recover = !recover;
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                })
                .start();
    }


    public void reLogin(View view) {
        LoginActivity.runActivity(mContext, LoginActivity.class);
    }


    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

}
