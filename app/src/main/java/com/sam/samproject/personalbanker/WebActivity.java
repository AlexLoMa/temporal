package com.sam.samproject.personalbanker;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.webkit.WebView;

import com.sam.samproject.R;
import com.sam.samproject.base.BaseActivity;

public class WebActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);
        final String url = getIntent().getStringExtra("url");

        WebView webView = findViewById(R.id.activity_web_view);
        webView.loadUrl(url);
    }
}
