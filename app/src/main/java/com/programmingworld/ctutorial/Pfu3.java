package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Pfu3 extends AppCompatActivity {
    WebView pfu3;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pfu3);
        pfu3=(WebView)findViewById(R.id.pfu3);
        pfu3.loadUrl("file:///android_asset/Sfu3.html");
       // MobileAds.initialize(this,"ca-app-pub-4994553913133799~7983890822");
        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}