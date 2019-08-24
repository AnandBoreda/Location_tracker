package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
public class RingtonesSave extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
  //  TextView txtView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtones_save);
      //  txtView = findViewById(R.id.txtView);

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

    } @Override
    public void onBackPressed()
    {
        Intertialshow();
    }
//TODO error : app crashing
   /* public void files(View view) {
        final Uri currentTone= RingtoneManager.getActualDefaultRingtoneUri(RingtonesSave.this, RingtoneManager.TYPE_ALARM);
        Intent intent = new Intent(RingtoneManager.ACTION_RINGTONE_PICKER);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TYPE, RingtoneManager.TYPE_RINGTONE);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_TITLE, "Select Tone");
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_EXISTING_URI, currentTone);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_SILENT, false);
        intent.putExtra(RingtoneManager.EXTRA_RINGTONE_SHOW_DEFAULT, true);
        startActivityForResult(intent, 999);
    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == 999 && resultCode == RESULT_OK){
            Uri uri = data.getParcelableExtra(RingtoneManager.EXTRA_RINGTONE_PICKED_URI);
            txtView.setText("From :" + uri.getPath());
            //Set selected ringtone here.
            RingtoneManager.setActualDefaultRingtoneUri(
                    this,
                    RingtoneManager.TYPE_RINGTONE,
                    uri
            );
        }
    } */

}
