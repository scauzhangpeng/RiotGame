package com.xyz.basiclib;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.StyleRes;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;

/**
 * Created by ZP on 2018/1/30.
 */

public class DefaultDialog extends Dialog {
    private static final String TAG = "DefaultDialog";
    private Context context;
    private Button mBtnCancel;
    private Button mBtnOk;

    public DefaultDialog(@NonNull Context context) {
        super(context, R.style.DefaultDialog);
        this.context = context;
    }

    public DefaultDialog(@NonNull Context context, @StyleRes int themeResId) {
        super(context, themeResId);
        this.context = context;
    }

    protected DefaultDialog(@NonNull Context context, boolean cancelable, @Nullable OnCancelListener cancelListener) {
        super(context, cancelable, cancelListener);
        this.context = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, "onCreate: ");
        View dialogView = LayoutInflater.from(context).inflate(R.layout.dialog_default, null);
        mBtnOk = (Button) dialogView.findViewById(R.id.btn_ok);
        mBtnCancel = (Button) dialogView.findViewById(R.id.btn_cancel);
        setContentView(dialogView);

        Window win = getWindow();
        WindowManager.LayoutParams lp = win.getAttributes();
        lp.gravity = Gravity.CENTER;
        int screenWidth = ScreenUtil.getScreenWidth(context);
        int paddingBothSize = ScreenUtil.dp2px(context, 80);
        int dialogWidth = screenWidth - paddingBothSize;
        lp.height = dialogWidth / 2;
        lp.width = dialogWidth;
        win.setAttributes(lp);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onStart: ");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "onStop: ");
    }

    public void setCancelListener(View.OnClickListener listener) {
        mBtnCancel.setOnClickListener(listener);
    }

    public void setOkListener(View.OnClickListener listener) {
        mBtnOk.setOnClickListener(listener);
    }
}
