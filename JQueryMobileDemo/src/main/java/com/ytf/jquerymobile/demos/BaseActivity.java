package com.ytf.jquerymobile.demos;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.URLUtil;
import android.widget.ProgressBar;

/**
 * Package: com.ytf.jquerymobile.demos
 * Created with JQueryMobileDemo
 * User: AndyHua
 * Date: 14-12-22
 * Time: 13:15
 * Description:
 */
public class BaseActivity extends Activity{
    private static final String TAG = "BaseActivity";

    public Context mContext;
    public Resources mReSources;
    private Dialog dialog;

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.mContext = this;
        mReSources = getResources();
    }

    /**
     *
     */
    @Override
    protected void onResume() {
        super.onResume();
    }

    /**
     *
     */
    @Override
    protected void onPause() {
        super.onPause();
    }

    /**
     *
     * @param newConfig
     */
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    /**
     *
     */
    public void showProgressDialog(){
        closeProgressDialog();

        dialog = new Dialog(mContext, R.style.TransparentDialog);
        dialog.setContentView(new ProgressBar(mContext));
        dialog.setCancelable(true);
        dialog.setCanceledOnTouchOutside(true);
        dialog.show();
    }

    /**
     *
     */
    public void closeProgressDialog(){
        if (dialog != null){
            dialog.cancel();
            dialog = null;
        }
    }

    /**
     *
     * @return
     */
    public boolean isShowing(){
        if (dialog != null){
            dialog.isShowing();
        }
        return false;
    }

    /**
     *
     * @param url
     */
    public void doOpenExplorer(String url){
        if (!URLUtil.isHttpUrl(url)){
            return;
        }

        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
