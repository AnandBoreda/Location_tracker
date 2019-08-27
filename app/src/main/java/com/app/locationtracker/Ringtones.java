package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class Ringtones extends AppCompatActivity {
    Button ring,save;
    private InterstitialAd mInterstitialAd;
    AdView mAdView,banner,nativ;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtones);
        ring = findViewById(R.id.ring_btn_main);
        save = findViewById(R.id.save_btn);
        //native
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        nativ = findViewById(R.id.native_adView);
        AdRequest natrequest = new AdRequest.Builder().build();
        nativ.loadAd(natrequest);

        //banner
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });

        banner = findViewById(R.id.banner_adView);
        AdRequest adrequest = new AdRequest.Builder().build();
        banner.loadAd(adrequest);
//end-banner


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

    public void ringtone_main_btn(View view) {
        startActivity(new Intent(this, RingtonesCreate.class));
        Intertialshow();
    }

    public void save_ring_btn(View view) {
        startActivity(new Intent(this, RingtonesSave.class));
        Intertialshow();
    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
        startActivity(new Intent(this, Home.class));
    }

    public void ringad(View view) {
        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
