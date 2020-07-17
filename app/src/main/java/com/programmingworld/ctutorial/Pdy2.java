package com.programmingworld.ctutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class Pdy2 extends AppCompatActivity {
    WebView pdy2;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pdy2);
        pdy2=(WebView)findViewById(R.id.pdy2);
        pdy2.loadUrl("file:///android_asset/Sdy2.html");



        //MobileAds.initialize(this,"ca-app-pub-4994553913133799~7983890822");

       // MobileAds.initialize(this,);
        MobileAds.initialize(this, initializationStatus -> { });
       // public static void initialize (Context context, OnInitializationCompleteListener listener)

        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }
}
