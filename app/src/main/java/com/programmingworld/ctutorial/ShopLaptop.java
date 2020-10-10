package com.programmingworld.ctutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ShopLaptop extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    AdView mAdView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_laptop);
        progressBar=(ProgressBar)findViewById(R.id.progress);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        webView = (WebView) findViewById(R.id.amazonlaptop);



        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = manager.getActiveNetworkInfo();
        boolean hasConnect = (i!= null && i.isConnected() && i.isAvailable());

        if(hasConnect)
        {
            // show the webview
            progressBar.setVisibility(View.VISIBLE);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://helpssite.com/amazon/laptop/laptop.html");
        }
        else
        {
            // do what ever you need when when no internet connection
            AlertDialog dialog=new AlertDialog.Builder(ShopLaptop.this).create();
            dialog.setTitle("Error");
            dialog.setCancelable(false);
            dialog.setMessage("Check Your Interner Connection And Try Again");
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    // finish();
                    Intent intent=new Intent(ShopLaptop.this,ShopCategory.class);
                    startActivity(intent);
                    finish();
                }
            });
            dialog.show();
        }



        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent=new Intent(ShopLaptop.this,ShopCategory.class);
        startActivity(intent);
        finish();
    }

}