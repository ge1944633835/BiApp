package com.blockbi.app.ui.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/23
 *     desc   :
 *     version:
 * </pre>
 */

public class MenuViewPager extends ViewPager {
    private int pageSize = 0;

    public MenuViewPager(@NonNull Context context) {
        super(context);
    }

    public MenuViewPager(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent ev) {

        int currentItem = this.getCurrentItem();

        if (currentItem == pageSize - 1) {
            this.getParent().requestDisallowInterceptTouchEvent(false);
        } else {
            this.getParent().requestDisallowInterceptTouchEvent(true);
        }

        return super.onTouchEvent(ev);
    }


    public void setPageSize(int page) {

        this.pageSize = page;
    }

}
