package org.scau.riotgame.webview;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;

import com.xyz.riotcommon.SimpleTopBarActivity;

import org.scau.riotgame.R;

/**
 * Created by ZP on 2017/8/3.
 */

public class WebViewActivity extends SimpleTopBarActivity {

    private static final String TAG = "WebViewActivity";

    private WebView mWebView;
    private FrameLayout mFlWebView;
    private WebSettings mWebSettings;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        mWebView = new WebView(getApplicationContext());
        mFlWebView.addView(mWebView);
        mWebSettings = WebViewConfig.initWebView(mWebView);

        String url = getIntent().getStringExtra("url");
        if (url != null && !TextUtils.isEmpty(url)) {
            mWebView.loadUrl(url);
        }

//        mWebView.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                System.out.println("url:" + url);
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                startActivity(intent);
//                return super.shouldOverrideUrlLoading(view, url);
//            }
//        });

        mWebView.setWebViewClient(mWebViewClient);

        mWebView.setWebChromeClient(mWebChromeClient);
    }

    @Override
    protected int getTopBarContentId() {
        return R.layout.activity_webview;
    }

    @Override
    protected void initViewsAndEvents(Bundle savedInstanceState) {

    }

    @Override
    protected void onResume() {
        super.onResume();
        mWebView.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mWebView.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mFlWebView.removeAllViews();
//        mWebView.clearCache(true);
        mWebView.destroy();
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void initView() {
        mFlWebView = (FrameLayout) findViewById(R.id.fl_webview);
    }

    private WebViewClient mWebViewClient = new WebViewClient() {
        @Override
        public void onPageFinished(WebView view, String url) {
            mWebSettings.setBlockNetworkImage(false);
            //判断WebView是否加载了，图片资源
            if (!mWebSettings.getLoadsImagesAutomatically()) {
                //设置wenView加载图片资源
                mWebSettings.setLoadsImagesAutomatically(true);
            }
            super.onPageFinished(view, url);
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, String url) {
            Log.d(TAG, "shouldInterceptRequest: " + url);
//            WebResourceResponse response = new WebResourceResponse("image/png","UTF-8", )
            return super.shouldInterceptRequest(view, url);
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView view, WebResourceRequest request) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//                Log.d(TAG, "shouldInterceptRequest: " + request.getUrl());
//                Log.d(TAG, "shouldInterceptRequest: " + request.toString());
            }
            return super.shouldInterceptRequest(view, request);
        }
    };

    private WebChromeClient mWebChromeClient = new WebChromeClient() {
        @Override
        public void onProgressChanged(WebView view, final int newProgress) {
            super.onProgressChanged(view, newProgress);
//            Log.d(TAG, "onProgressChanged: " + newProgress);
        }
    };
}
