package org.scau.riotgame.webview;

import android.webkit.WebSettings;
import android.webkit.WebView;

/**
 * Created by ZP on 2017/8/3.
 */

public class WebViewConfig {

    public static WebSettings initWebView(WebView webView) {
        WebSettings webSettings = webView.getSettings();
        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
        webSettings.setJavaScriptEnabled(true);
        webSettings.setBlockNetworkImage(true);
        return webSettings;
    }
}
