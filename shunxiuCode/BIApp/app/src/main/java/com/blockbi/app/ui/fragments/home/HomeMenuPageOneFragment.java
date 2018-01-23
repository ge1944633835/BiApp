package com.blockbi.app.ui.fragments.home;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import com.blockbi.app.HomeActivity;
import com.blockbi.app.R;

import java.util.Locale;

import butterknife.OnClick;
import me.sunlight.sdk.common.Common;
import me.sunlight.sdk.common.app.Activity;
import me.sunlight.sdk.common.app.Fragment;
import me.sunlight.sdk.common.widget.dialog.ActionSheetDialog;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/23
 *     desc   :
 *     version:
 * </pre>
 */

public class HomeMenuPageOneFragment extends Fragment {

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_home_menu_page_one;
    }




    @OnClick(R.id.home_menu_tv_setting)
    public void onViewClicked() {

        new ActionSheetDialog(mContext)
                .builder()
                .setCancelable(true)
                .setCanceledOnTouchOutside(true)
                .addSheetItem(getResources().getString(R.string.label_setting_title), ActionSheetDialog.SheetItemColor.Blue,
                        which -> {
                        }
                ).addSheetItem(getResources().getString(R.string.label_setting_chinese), ActionSheetDialog.SheetItemColor.Blue,
                which -> set(Common.Constants.LANGUAGE_CHINESE)
        ).addSheetItem(getResources().getString(R.string.label_setting_english), ActionSheetDialog.SheetItemColor.Blue,
                which -> set(Common.Constants.LANGUAGE_ENGLISH)
        ).show();

    }

    /**
     * 设置语言
     *
     * @param lauType
     */
    private void set(String lauType) {
        // 本地语言设置
        Locale myLocale = new Locale(lauType);
        Resources res = getResources();
        DisplayMetrics dm = res.getDisplayMetrics();
        Configuration conf = res.getConfiguration();
        conf.locale = myLocale;
        res.updateConfiguration(conf, dm);

        // 销毁重建，否则无法刷新
        ((Activity)mContext).finish();
        HomeActivity.runActivity(mContext, HomeActivity.class);

    }

}
