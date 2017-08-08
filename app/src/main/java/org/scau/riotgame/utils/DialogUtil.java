package org.scau.riotgame.utils;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/7.
 */

public class DialogUtil {

    public static Dialog createFrameProgressDialog(Context context, String msg) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.dialog_frame_progress, null);

        LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.ll_frame_dialog);
        ImageView imageView = (ImageView) view.findViewById(R.id.iv_progress);
        TextView textView = (TextView) view.findViewById(R.id.tv_msg);

        AnimationDrawable ad = (AnimationDrawable) imageView.getDrawable();
        ad.start();

        textView.setText(msg);

        Dialog dialog = new Dialog(context, R.style.loading_dialog);    //
        dialog.setCancelable(true);         // 设置按返回键时取消对话框
        dialog.setCanceledOnTouchOutside(false);    // 设置点击对话框外部时不取消对话框，默认为true
        dialog.setContentView(linearLayout, new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT
        ));
        return dialog;
    }
}
