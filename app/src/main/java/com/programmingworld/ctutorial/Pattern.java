package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

public class Pattern extends AppCompatActivity {
    WebView pattern;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pattern);
        pattern=(WebView)findViewById(R.id.pattern);
        pattern.loadUrl("file:///android_asset/Pattern.html");
    }
}
