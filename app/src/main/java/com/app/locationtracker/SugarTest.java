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

public class SugarTest extends AppCompatActivity {
    Button hlth,lvls,info,map,tst,hba1c,low,report;
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_test);
        hlth = findViewById(R.id.health_tips);
        lvls = findViewById(R.id.sugar_lvls);
        info = findViewById(R.id.sugar_info_btn);
        map = findViewById(R.id.bsworld_map);
        tst = findViewById(R.id.sugar_test_main);
        hba1c = findViewById(R.id.hba1c_bttn);
        low = findViewById(R.id.lowsug_bttn);
        report = findViewById(R.id.sug_report);
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
    { finish(); } }


    public void health_tips_bttn(View view) {

        startActivity(new Intent(this, HealthTips.class));
    }

    public void sugar_lvls(View view) {

        startActivity(new Intent(this, SugarLevels.class));
    }

    public void sugar_inf(View view) {

        startActivity(new Intent(this, SugarInfo.class));
    }

    public void bsmap(View view) {
        startActivity(new Intent(this, BSWorldMap.class));
        Intertialshow();
    }

    public void sug_tst(View view) {
        startActivity(new Intent(this, SugarTestMain.class));
        Intertialshow();

    }

    public void dbts(View view) {
        startActivity(new Intent(this, DiabetesMain.class));
        Intertialshow();
    }

    public void hba1c_bttn(View view) {
        startActivity(new Intent(this, HbA1cMain.class));
        Intertialshow();
    }

    public void lowsugr(View view) { startActivity(new Intent(this, LowSugar.class));
        Intertialshow();
    }

    public void sugreport(View view) {
        startActivity(new Intent(this, SugReport.class));
        Intertialshow();
    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
        startActivity(new Intent(this, Home.class));
    }
}
