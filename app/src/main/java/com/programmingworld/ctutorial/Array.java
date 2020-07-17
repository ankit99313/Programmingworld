package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Array extends AppCompatActivity {
    WebView warray;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_array);
        warray=(WebView)findViewById(R.id.warray);

       // WebSettings webSettings=warray.getSettings();
       // webSettings.setBuiltInZoomControls(true);
       // webSettings.setDisplayZoomControls(true);


        //getSupportActionBar().setDisplayShowHomeEnabled(true);
       // getSupportActionBar().setDefaultDisplayHomeAsUpEnabled(true);

        warray.loadUrl("file:///android_asset/Sarray.html");
        MobileAds.initialize(this, initializationStatus -> { });
       // MobileAds.initialize(this,"ca-app-pub-4994553913133799~7983890822");
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
