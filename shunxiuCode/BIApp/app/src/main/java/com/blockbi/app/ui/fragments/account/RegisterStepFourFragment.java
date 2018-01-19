package com.blockbi.app.ui.fragments.account;

import android.content.Intent;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.ImageView;

import com.blockbi.app.R;
import com.blockbi.app.ui.activities.account.RegisterCompleteActivity;

import net.qiujuer.genius.ui.widget.Button;

import java.io.File;

import butterknife.BindView;
import butterknife.OnClick;
import me.iwf.photopicker.PhotoPicker;
import me.sunlight.sdk.common.app.Activity;
import me.sunlight.sdk.common.app.Fragment;
import me.sunlight.sdk.common.widget.dialog.ActionSheetDialog;

/**
 * <pre>
 *     author : 戈传光
 *     e-mail : 1944633835@qq.com
 *     time   : 2018/01/17
 *     desc   :
 *     version:
 * </pre>
 */
public class RegisterStepFourFragment extends Fragment {


    @BindView(R.id.register_img_photo)
    ImageView mImgPhoto;
    @BindView(R.id.register_tv_jump)
    Button mTvJump;

    // 保存拍照的路径
    private String saveDir = Environment.getExternalStorageDirectory().getAbsolutePath()
            + File.separator + "BiBlock" + File.separator + "portview";
    private File image;
    private static final int PORTVIEW_ALBUM_CODE = 123;
    private static final int PORTVIEW_TAKEPHOTO_CODE = 124;

    public static final String USER_INFO_KEY = "USER_INFO_KEY";

    public static RegisterStepFourFragment newInstance() {
        RegisterStepFourFragment fragment = new RegisterStepFourFragment();
        return fragment;
    }

    @Override
    protected int getContentLayoutId() {
        return R.layout.fragment_register_step_four;
    }



    @OnClick({R.id.register_img_photo, R.id.register_tv_jump})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.register_img_photo:
                new ActionSheetDialog(mContext)
                        .builder()
                        .setCancelable(true)
                        .setCanceledOnTouchOutside(true)
                        .addSheetItem("用相机选择图片", ActionSheetDialog.SheetItemColor.Blue.Blue,
                                which -> {
                                    // 使用相机
                                    Intent intent = new Intent();
                                    File file = new File(saveDir);
                                    if (!file.exists()) {
                                        file.mkdirs();
                                    }
                                    image = new File(file, System.currentTimeMillis()
                                            + "portview.jpg");
                                    Uri uri = Uri.fromFile(image);
                                    intent.setAction(MediaStore.ACTION_IMAGE_CAPTURE);
                                    intent.putExtra(MediaStore.EXTRA_OUTPUT, uri);
                                    startActivityForResult(intent, PORTVIEW_TAKEPHOTO_CODE);
                                })
                        .addSheetItem("去相册选择图片", ActionSheetDialog.SheetItemColor.Blue,
                                which -> PhotoPicker.builder()
                                        .setPhotoCount(1)
                                        .setShowCamera(true)
                                        .setShowGif(true)
                                        .setPreviewEnabled(false)
                                        .start((Activity) mContext, PORTVIEW_ALBUM_CODE)
                        ).show();
                break;
            case R.id.register_tv_jump:
                RegisterCompleteActivity.runActivity(mContext,RegisterCompleteActivity.class);
                break;
        }
    }
}
