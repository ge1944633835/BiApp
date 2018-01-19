package me.sunlight.sdk.common.network.callback;

import android.app.Activity;
import android.app.ProgressDialog;
import android.view.Window;

import com.lzy.okgo.callback.StringCallback;
import com.lzy.okgo.request.base.Request;

/**
 * Created by gechuanguang on 2017/7/24.
 * 邮箱：1944633835@qq.com
 */
public abstract class DialogStringCallback extends StringCallback {
    private ProgressDialog dialog;
    @Override
    public void onStart(Request<String, ? extends Request> request) {
        super.onStart(request);
        if (dialog != null && !dialog.isShowing()) {
            dialog.show();
        }
    }
    public DialogStringCallback(Activity activity) {
        initDialog(activity);
    }

    private void initDialog(Activity activity) {
        dialog = new ProgressDialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);
        dialog.setMessage("请求网络中...");
    }

    @Override
    public void onFinish() {
        //网络请求结束后关闭对话框
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }
}
