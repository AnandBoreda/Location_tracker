package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;

public class FlashScreenMain extends AppCompatActivity {
    Button torch, siren, scrlight, traffic, dj, clrlight;
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen_main);
        torch = findViewById(R.id.torchmain);
        siren = findViewById(R.id.policelight);
        scrlight= findViewById(R.id.scrlight);
        traffic= findViewById(R.id.trafficlightbtn);
        dj = findViewById(R.id.djlightbtn);
        clrlight= findViewById(R.id.colorlightbtn);

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

    public void siren(View view) {
        startActivity(new Intent(this, PoliceSirenMain.class));
        Intertialshow();
    }

    public void torch(View view) {
        startActivity(new Intent(this, TorchMain.class));
        Intertialshow();
    }

    public void screenlight(View view) {
        startActivity(new Intent(this, ScreenLightMain.class));
        Intertialshow();
    }

public void trafficlight(View view) {
    startActivity(new Intent(this, TrafficLightMain.class));
    Intertialshow();
    }

    public void djlight(View view) {
        startActivity(new Intent(this, DjLightsMain.class));
        Intertialshow();
    }

    public void colorlight(View view) {
        startActivity(new Intent(this, ColorLightMain.class));
        Intertialshow();
    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }
}
