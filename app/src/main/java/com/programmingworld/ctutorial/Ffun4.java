package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Ffun4 extends AppCompatActivity {
    WebView ffun4;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ffun4);
        ffun4=(WebView)findViewById(R.id.ffun4);
        ffun4.loadUrl("file:///android_asset/Ffun4.html");
        MobileAds.initialize(this, initializationStatus -> { });
        //MobileAds.initialize(this,"ca-app-pub-4994553913133799~7983890822");
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
