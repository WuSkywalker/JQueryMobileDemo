package com.ytf.jquerymobile.demos;

import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebSettings;
import android.webkit.WebView;

public class MainActivity extends BaseActivity {

    private WebView mWebView;
    private WebSettings settings;
    private Handler mHandler = new Handler();

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mWebView = (WebView) findViewById(R.id.webView);

        init();
    }

    /**
     *
     */
    private void init() {
        settings = mWebView.getSettings();
        settings.setSupportZoom(true);
        settings.setJavaScriptEnabled(true);
        mWebView.requestFocus();
        mWebView.setWebViewClient(new XWebViewClient(this));
        mWebView.setWebChromeClient(new XWebChromeClient());

        mWebView.addJavascriptInterface(new Object() {
            public void clickOnAndroid() {
                mHandler.post(new Runnable() {
                    public void run() {
                        mWebView.loadUrl("javascript:wave()");
                    }
                });
            }
        }, "demo");

        mWebView.loadUrl("file:///android_asset/index.html");
    }


}
