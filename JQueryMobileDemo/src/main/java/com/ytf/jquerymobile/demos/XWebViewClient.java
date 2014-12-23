package com.ytf.jquerymobile.demos;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * Package: com.ytf.jquerymobile.demos
 * Created with JQueryMobileDemo
 * User: AndyHua
 * Date: 14-12-22
 * Time: 13:10
 * Description:
 */
public class XWebViewClient extends WebViewClient{
    private static final String TAG = "XWebViewClient";

    private BaseActivity activity;

    /**
     *
     * @param activity
     */
    public XWebViewClient(BaseActivity activity) {
        this.activity = activity;
    }

    /**
     *
     * @param view
     * @param url
     * @return
     */
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        view.loadUrl(url);
        return true;
    }

    /**
     *
     * @param view
     * @param url
     * @param favicon
     */
    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        activity.showProgressDialog();
    }

    /**
     *
     * @param view
     * @param url
     */
    @Override
    public void onPageFinished(WebView view, String url) {
        activity.closeProgressDialog();
    }

    /**
     *
     * @param view
     * @param errorCode
     * @param description
     * @param failingUrl
     */
    @Override
    public void onReceivedError(WebView view, int errorCode, String description, String failingUrl) {
        activity.closeProgressDialog();
    }


}
