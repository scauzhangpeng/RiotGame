package org.scau.riotgame.launcher;

import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;

import com.google.gson.Gson;
import com.tencent.connect.UserInfo;
import com.tencent.connect.common.Constants;
import com.tencent.tauth.IUiListener;
import com.tencent.tauth.Tencent;
import com.tencent.tauth.UiError;
import com.xyz.basiclib.mvp.BasePresenter;
import com.xyz.basiclib.util.SPUtil;
import com.xyz.riotcommon.CommonActivity;

import org.json.JSONObject;
import org.scau.riotgame.R;
import org.scau.riotgame.home.MainActivity;
import org.scau.riotgame.home.bean.QQLogin;

import butterknife.OnClick;


/**
 * Created by ZP on 2017/8/2.
 * <p>
 * 登录界面
 * </p>
 */

public class LoginActivity extends CommonActivity {

    private Tencent mTencent;
    private UserInfo mInfo;
    private String app_id = "1105966790";

    @Override
    protected void initTopBar(View topView) {

    }

    @Override
    protected int getTopBarContentId() {
        return 0;
    }

    @Override
    protected int getTopBarLayoutId() {
        return 0;
    }

    @Override
    protected int getLayoutId() {
        return R.layout.activity_login;
    }

    @Override
    protected BasePresenter initPresenter() {
        return null;
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("TAG", "-->onActivityResult " + requestCode + " resultCode=" + resultCode);
        if (requestCode == Constants.REQUEST_LOGIN ||
                requestCode == Constants.REQUEST_APPBAR) {
            Tencent.onActivityResultData(requestCode, resultCode, data, mLoginListener);
        }

        super.onActivityResult(requestCode, resultCode, data);
    }

    @OnClick(R.id.ll_login)
    public void goLogin(View view) {

        if (mTencent == null) {
            mTencent = Tencent.createInstance(app_id, this);
        }
        if (!mTencent.isSessionValid()) {
            mTencent.login(this, "all", mLoginListener);
        } else {
            //mTencent.logout(this);
            updateUserInfo();
        }

    }

    private IUiListener mLoginListener = new IUiListener() {
        @Override
        public void onComplete(Object response) {
            if (response == null) {
                System.out.println("response == null");
                return;
            }
            System.out.println("resp1:" + response.toString());
            initOpenidAndToken((JSONObject) response);
            updateUserInfo();
        }

        @Override
        public void onError(UiError uiError) {
            System.out.println("error:" + uiError.errorDetail);
            System.out.println("error:" + uiError.errorMessage);
            System.out.println("error:" + uiError.errorCode);
        }

        @Override
        public void onCancel() {
            System.out.println("cancel");
        }
    };

    public void initOpenidAndToken(JSONObject jsonObject) {
        try {
            String token = jsonObject.getString(Constants.PARAM_ACCESS_TOKEN);
            String expires = jsonObject.getString(Constants.PARAM_EXPIRES_IN);
            String openId = jsonObject.getString(Constants.PARAM_OPEN_ID);
            if (!TextUtils.isEmpty(token) && !TextUtils.isEmpty(expires)
                    && !TextUtils.isEmpty(openId)) {
                mTencent.setAccessToken(token, expires);
                mTencent.setOpenId(openId);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateUserInfo() {
        if (mTencent != null && mTencent.isSessionValid()) {
            IUiListener listener = new IUiListener() {

                @Override
                public void onError(UiError uiError) {
                    System.out.println("error:" + uiError.errorDetail);
                    System.out.println("error:" + uiError.errorMessage);
                    System.out.println("error:" + uiError.errorCode);
                }

                @Override
                public void onComplete(Object response) {
                    System.out.println("resp2:" + response.toString());
                    Gson gson = new Gson();
                    QQLogin qqLogin = gson.fromJson(response.toString(), QQLogin.class);
                    SPUtil.getInstance(LoginActivity.this).put("figureurl_qq_2", qqLogin.getFigureurl_qq_2());
                    openActivity(MainActivity.class);
                }

                @Override
                public void onCancel() {
                    System.out.println("cancel");
                }
            };
            mInfo = new UserInfo(this, mTencent.getQQToken());
            mInfo.getUserInfo(listener);
        }
    }
}
