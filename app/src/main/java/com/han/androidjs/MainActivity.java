package com.han.androidjs;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private static final String LOGIN_URL = "file:///android_asset/login.html";
    private static final String INDEX_URL = "file:///android_asset/index.html";
    private WebView mWebView;
    private Button mBtnLogin;
    private String username = "";
    private String password = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mWebView = findViewById(R.id.id_webview);
        mBtnLogin = findViewById(R.id.btn_js);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                login();
            }
        });
        initWebView();
        mWebView.loadUrl(LOGIN_URL);
    }

    private void initWebView() {
        WebSettings webSettings = mWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        mWebView.addJavascriptInterface(new JSBridge(this), "android");
        mWebView.setWebViewClient(new WebViewClient());
        mWebView.setWebChromeClient(new MyWebChromeClient(this));
    }

    private void showDialogInHtml(String msg) {
        mWebView.loadUrl("javascript:showDialog(\"" + msg + "\")");
    }

    private void login() {
        mWebView.evaluateJavascript("login()", new ValueCallback<String>() {
            @Override
            public void onReceiveValue(String s) {
                if (!TextUtils.isEmpty(s) && !"null".equals(s)) {
                    s = s.substring(1, s.length() - 1);
                    username = s.trim().split("-")[0];
                    password = s.trim().split("-")[1];
                }

                if (!TextUtils.isEmpty(username) && !TextUtils.isEmpty(password)) {
                    if ("admin".equals(username) && "123456".equals(password)) {
                        Toast.makeText(MainActivity.this, "登录成功", Toast.LENGTH_SHORT).show();
                        mWebView.loadUrl(INDEX_URL);
                        mBtnLogin.setVisibility(View.GONE);
                    } else {
                        showDialogInHtml("用户名或密码不正确");
//                Toast.makeText(MainActivity.this,"用户名或密码不正确",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

}
