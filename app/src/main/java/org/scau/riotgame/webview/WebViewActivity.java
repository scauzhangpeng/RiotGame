package org.scau.riotgame.webview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.LinearLayout;

import org.scau.riotgame.R;

import java.util.HashMap;
import java.util.Map;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by ZP on 2017/8/3.
 */

public class WebViewActivity extends AppCompatActivity {

    @BindView(R.id.ll_root)
    LinearLayout mLlRoot;

    private WebView mWebView;
    private Map<String, String> extraHeaders;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        mWebView = new WebView(this);
        mLlRoot.addView(mWebView);
        WebViewConfig.initWebView(mWebView);

        extraHeaders = new HashMap<String, String>();
        extraHeaders.put("device", "Android");
        extraHeaders.put("version", "1.0");
        extraHeaders.put("Cache-control", "max-age=10");
        mWebView.loadUrl("http://qt.qq.com/php_cgi/news/php/varcache_article.php?id=35069&version=$PROTO_VERSION$&areaid=$REGION$",
                extraHeaders);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mLlRoot.removeAllViews();
//        mWebView.clearCache(true);
        mWebView.destroy();
    }
}
