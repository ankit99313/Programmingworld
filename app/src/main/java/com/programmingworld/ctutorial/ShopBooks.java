package com.programmingworld.ctutorial;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;

public class ShopBooks extends AppCompatActivity {
    Toolbar toolbar;
    WebView webView;
    AdView mAdView;
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop_books);
        progressBar=(ProgressBar)findViewById(R.id.progress);


        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        webView = (WebView) findViewById(R.id.amazonbooks);



        ConnectivityManager manager = (ConnectivityManager)getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo i = manager.getActiveNetworkInfo();
        boolean hasConnect = (i!= null && i.isConnected() && i.isAvailable());

        if(hasConnect)
        {
            // show the webview
            progressBar.setVisibility(View.VISIBLE);
            webView.getSettings().setJavaScriptEnabled(true);
            webView.loadUrl("https://helpssite.com/amazon/book/book.html");
        }
        else
        {
            // do what ever you need when when no internet connection
            AlertDialog dialog=new AlertDialog.Builder(ShopBooks.this).create();
            dialog.setTitle("Error");
            dialog.setCancelable(false);
            dialog.setMessage("Check Your Interner Connection And Try Again");
            dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                   // finish();
                    Intent intent=new Intent(ShopBooks.this,ShopCategory.class);
                    startActivity(intent);
                    finish();
                }
            });
            dialog.show();
        }


       /* webView.setWebViewClient(new WebViewClient(){
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                super.onPageStarted(view, url, favicon);
                progressBar.setVisibility(View.VISIBLE);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                progressBar.setVisibility(View.GONE);
            }


            @Override
            public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
               // super.onReceivedError(view, request, error);
                webView.stopLoading();
                webView.loadUrl("about:blank");

                AlertDialog dialog=new AlertDialog.Builder(ShopBooks.this).create();
                dialog.setTitle("Error");
                dialog.setMessage("Check Your Interner Connection And Try Again");
                dialog.setButton(DialogInterface.BUTTON_POSITIVE, "OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                        startActivity(new Intent(ShopBooks.this,ShopCategory.class));
                    }
                });
                dialog.show();
            }


            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                return super.shouldOverrideUrlLoading(view, request);
            }
        });*/





        MobileAds.initialize(this, initializationStatus -> { });
        mAdView=(AdView)findViewById(R.id.adView);
        AdRequest adRequest=new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
    }

    @Override
    public void onBackPressed() {
         super.onBackPressed();
        Intent intent=new Intent(ShopBooks.this,ShopCategory.class);
        startActivity(intent);
        finish();
    }

}