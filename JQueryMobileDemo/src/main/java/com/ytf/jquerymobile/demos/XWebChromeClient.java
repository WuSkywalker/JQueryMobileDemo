package com.ytf.jquerymobile.demos;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.os.Message;
import android.util.Log;
import android.view.KeyEvent;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.widget.EditText;

/**
 * Package: com.ytf.jquerymobile.demos
 * Created with JQueryMobileDemo
 * User: AndyHua
 * Date: 14-12-22
 * Time: 13:04
 * Description:
 */
public class XWebChromeClient extends WebChromeClient {
    private static final String TAG = "XWebChromeClient";

    /**
     * @param window
     */
    @Override
    public void onCloseWindow(WebView window) {
        super.onCloseWindow(window);
    }

    /**
     * @param view
     * @param isDialog
     * @param isUserGesture
     * @param resultMsg
     * @return
     */
    @Override
    public boolean onCreateWindow(WebView view, boolean isDialog, boolean isUserGesture, Message resultMsg) {
        return super.onCreateWindow(view, isDialog, isUserGesture, resultMsg);
    }

    /**
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsAlert(WebView view, String url, String message, JsResult result) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("对话框").setMessage(message).setPositiveButton("确定", null);

        // 屏蔽keycode等于84之类的按键，避免按键后导致对话框消息而页面无法再弹出对话框的问题
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode, KeyEvent event) {
                Log.v("onJsAlert", "keyCode==" + keyCode + "event=" + event);
                return true;
            }
        });

        builder.setCancelable(false);

        AlertDialog dialog = builder.create();
        dialog.show();
        result.confirm();
        return true;
    }

    /**
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsBeforeUnload(WebView view, String url, String message, final JsResult result) {
        return super.onJsBeforeUnload(view, url, message, result);
    }

    /**
     * @param view
     * @param url
     * @param message
     * @param result
     * @return
     */
    @Override
    public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("对话框").setMessage(message).setPositiveButton("确定",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.confirm();
                    }
                }).setNegativeButton("取消",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        result.cancel();
                    }
                });

        builder.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                result.cancel();
            }
        });

        // 屏蔽keycode等于84之类的按键，避免按键后导致对话框消息而页面无法再弹出对话框的问题
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            @Override
            public boolean onKey(DialogInterface dialog, int keyCode,KeyEvent event) {
                Log.v("onJsConfirm", "keyCode==" + keyCode + "event="+ event);
                return true;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        return true;
    }

    /**
     * @param view
     * @param url
     * @param message
     * @param defaultValue
     * @param result
     * @return
     */
    @Override
    public boolean onJsPrompt(WebView view, String url, String message, String defaultValue, final JsPromptResult result) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext());
        builder.setTitle("对话框").setMessage(message);

        final EditText et = new EditText(view.getContext());
        et.setSingleLine();
        et.setText(defaultValue);

        builder.setView(et).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.confirm(et.getText().toString());
            }
        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                result.cancel();
            }
        });

        // 屏蔽keycode等于84之类的按键，避免按键后导致对话框消息而页面无法再弹出对话框的问题
        builder.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialog, int keyCode,KeyEvent event) {
                Log.v("onJsPrompt", "keyCode==" + keyCode + "event="+ event);
                return true;
            }
        });

        AlertDialog dialog = builder.create();
        dialog.show();

        return true;
    }

    /**
     * @param view
     * @param newProgress
     */
    @Override
    public void onProgressChanged(WebView view, int newProgress) {
        super.onProgressChanged(view, newProgress);
    }

    /**
     * @param view
     * @param icon
     */
    @Override
    public void onReceivedIcon(WebView view, Bitmap icon) {
        super.onReceivedIcon(view, icon);
    }

    /**
     * @param view
     * @param title
     */
    @Override
    public void onReceivedTitle(WebView view, String title) {
        super.onReceivedTitle(view, title);
    }

    /**
     * @param view
     */
    @Override
    public void onRequestFocus(WebView view) {
        super.onRequestFocus(view);
    }
}
