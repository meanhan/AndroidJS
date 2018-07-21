package com.han.androidjs;

import android.content.Context;
import android.os.Build;
import android.webkit.JavascriptInterface;

/**
 * Created by xuhan on 18-7-19.
 */

public class JSBridge {

    private Context mContext;

    public JSBridge(Context mContext) {
        this.mContext = mContext;
    }


    @JavascriptInterface
    public String getDeviceMsg() {
        StringBuilder builder = new StringBuilder();
        builder.append(android.os.Build.BRAND)  //手机品牌
                .append("-")
                .append(Build.MODEL) // 手机型号
                .append("-")
                .append(android.os.Build.VERSION.RELEASE) // 安卓系统版本
                .append("-")
                .append(Build.VERSION.SDK_INT); // SDK版本

        return builder.toString();
    }


}
