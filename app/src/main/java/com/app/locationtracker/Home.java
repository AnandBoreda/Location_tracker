package com.app.locationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
    Button button_sugar_test, button_compass, button_loc, button_ringtones, button_flash_tools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button_sugar_test  = findViewById(R.id.suglevlchart);
        button_compass = findViewById(R.id.compass_btn);
        button_loc = findViewById(R.id.loc_btn);
        button_ringtones = findViewById(R.id.ring_btn);
        button_flash_tools = findViewById(R.id.flash_btn);

        MobileAds.initialize(this, "ca-app-pub-3940256099942544/1033173712");
        //ca-app-pub-3940256099942544/8691691433
        mAdView = findViewById(R.id.adView);
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mInterstitialAd = new InterstitialAd(this);
        mInterstitialAd.setAdUnitId("ca-app-pub-3940256099942544/1033173712");
        mInterstitialAd.loadAd(new AdRequest.Builder().build());
        mInterstitialAd.setAdListener(new AdListener() {
            @Override public void onAdClosed()
            { mInterstitialAd.loadAd(new AdRequest.Builder().build()); } });

        //woohoo

        mAdView = findViewById(R.id.adView);
        adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);
        mAdView.setAdListener(new AdListener(){
            @Override
            public void onAdClosed() {
                super.onAdClosed();
            }

            @Override
            public void onAdOpened() {
                super.onAdOpened();
            }

            @Override
            public void onAdLoaded() {
                super.onAdLoaded();
            }

            @Override
            public void onAdClicked() {
                super.onAdClicked();
            }

            @Override
            public void onAdImpression() {
                super.onAdImpression();
            }
        });


    }
    public void Intertialshow()
    { if (mInterstitialAd.isLoaded()) { mInterstitialAd.show(); }
    else
    { finish(); }

    }

    public void sugar_test(View view) {
        startActivity(new Intent(this, SugarTest.class));
        Intertialshow();
    }

    public void compass(View view) {
        startActivity(new Intent(this, Compass.class));
        Intertialshow();
    }

    public void loc_tracker(View view) {
        startActivity(new Intent(this, MobileLocator.class));
        Intertialshow();
    }

    public void ringtones(View view) {
        startActivity(new Intent(this, Ringtones.class));
        Intertialshow();

    }

    public void flash_tools(View view) {
        startActivity(new Intent(this, FlashTools.class));
        Intertialshow();
    }
    @Override
    public void onBackPressed()
    {
        startActivity(new Intent(this, Exit.class));
        Intertialshow();
    }
}