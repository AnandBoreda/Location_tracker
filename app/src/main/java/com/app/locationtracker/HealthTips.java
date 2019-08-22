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

public class HealthTips extends AppCompatActivity {
    Button eff, strat, expect, body, add, infla, reason, hema, fasting;
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);
        strat = findViewById(R.id.sevenstrat);
       eff = findViewById(R.id.smokingeff);
        expect= findViewById(R.id.expectsug);
        body= findViewById(R.id.bodysug);
        add= findViewById(R.id.sugadd);
        infla= findViewById(R.id.suginfla);
        fasting= findViewById(R.id.fastsug);
        reason = findViewById(R.id.sugreason);
        hema = findViewById(R.id.sughema);
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

    public void fasting(View view) {
        startActivity(new Intent(this, SugarFastingLevels.class));
        Intertialshow();
    }

    public void hema(View view) {
        startActivity(new Intent(this, SugarHema.class));
        Intertialshow();
    }

    public void reasons(View view) {
        startActivity(new Intent(this, SugarReasons.class));
        Intertialshow();
    }

    public void sugarinfla(View view) {
        startActivity(new Intent(this, SugarInflamation.class));
        Intertialshow();
    }

    public void sugaradd(View view) {
        startActivity(new Intent(this, SugarAddiction.class));
        Intertialshow();
    }

    public void bodycontrols(View view) {
        startActivity(new Intent(this, SugarBodyControl.class));
        Intertialshow();
    }

    public void sugar_inf(View view) {
        startActivity(new Intent(this, SugarInfo.class));
        Intertialshow();
    }

    public void sevenstrart(View view) {
        startActivity(new Intent(this, SugarStrategies.class ));
        Intertialshow();
    }

    public void smokeeff(View view) {
        startActivity(new Intent(this, SmokeEff.class));
        Intertialshow();
    }

    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }
}
