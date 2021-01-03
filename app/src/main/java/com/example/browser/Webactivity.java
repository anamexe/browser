package com.example.browser;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class Webactivity extends AppCompatActivity {

    WebView web;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webactivity);
        web=findViewById(R.id.web);
        Intent intent=getIntent();
        String wb=intent.getStringExtra("links");
        web.setWebViewClient(new WebViewClient());
        web.loadUrl(wb);
        WebSettings webSettings=web.getSettings();
        webSettings.setJavaScriptEnabled(true);
    }


}