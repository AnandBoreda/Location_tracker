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

public class CallBlocker extends AppCompatActivity {
    Button newnum,rec_calls,contactsbut,blklist;
    private InterstitialAd mInterstitialAd;
    AdView mAdView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_blocker);
        newnum = findViewById(R.id.add_new);
        rec_calls = findViewById(R.id.from_call_logs);
        contactsbut = findViewById(R.id.from_contacts);
        blklist = findViewById(R.id.blocked_list);
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

    public void newnum(View view) {
        startActivity(new Intent(this, NewNumBlock.class));
        Intertialshow();


    }

    public void fromconblk(View view) {
        startActivity(new Intent(this, BlockContacts.class));
        Intertialshow();

    }

    public void fromlogs(View view) {
        startActivity(new Intent(this, BlockFromLogs.class));
        Intertialshow();

    }

    public void blklist(View view) {
        startActivity(new Intent(this, BlockedList.class));
        Intertialshow();

    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }
}
