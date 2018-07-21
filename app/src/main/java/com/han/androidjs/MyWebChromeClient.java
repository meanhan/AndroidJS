package com.han.androidjs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebView;

/**
 * Created by xuhan on 18-7-20.
 */

public class MyWebChromeClient extends WebChromeClient {

    private Context mContext;

    public MyWebChromeClient(Context mContext) {
        this.mContext = mContext;
    }

    @Override
    public boolean onJsAlert(final WebView view, String url, String message, JsResult result) {

        new AlertDialog.Builder(mContext)
                .setTitle("提示")
                .setMessage(message)
                .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
//                        view.reload();
                    }
                })
                .show();
        result.confirm();
        return true;
    }
}
