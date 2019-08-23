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

public class SugarLevels extends AppCompatActivity {
    Button a,b,c,d,e,f,g,h,i;
    private InterstitialAd mInterstitialAd;
    AdView mAdView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        a = findViewById(R.id.ageabove);
        b = findViewById(R.id.agebelow);
       c = findViewById(R.id.pregnant);
        d= findViewById(R.id.suglevelsmm);
        e= findViewById(R.id.glulcose);
        f= findViewById(R.id.kidsadults);
        g= findViewById(R.id.riskweight);
        h= findViewById(R.id.sugchart);
       i = findViewById(R.id.suglevlchart);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_levels);
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

    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }

    public void ageabove(View view) { startActivity(new Intent(this, Ageabove.class));
    }

    public void agebelow(View view) {startActivity(new Intent(this, Agebelow.class));
    }

    public void pregnant(View view) {startActivity(new Intent(this, Pregnant.class));
    }

    public void suglevelsmain(View view) {startActivity(new Intent(this, sugarLevelsmain.class));
    }

    public void glucose(View view) {startActivity(new Intent(this, GlucoseLevels.class));
    }

    public void kidsadults(View view) {startActivity(new Intent(this, KidsAdults.class));
    }

    public void atrisk(View view) {startActivity(new Intent(this, AtRisk.class));
    }

    public void sugchart(View view) {startActivity(new Intent(this, SugarChartMain.class));
    }

    public void sugchartmainoo(View view) {startActivity(new Intent(this, SugLvlChart.class));
    }
}
