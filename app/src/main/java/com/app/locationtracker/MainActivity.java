package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.NativeExpressAdView;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private InterstitialAd mInterstitialAd;
    AdView mAdView;
    Button button;
    Button bt;
    private static String LOG_TAG = "EXAMPLE";

    NativeExpressAdView mAdViewNative;
    VideoController mVideoController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.start_button);
        bt = findViewById(R.id.share_app_id);
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



        //native
        // Locate the NativeExpressAdView.
        mAdViewNative = (NativeExpressAdView) findViewById(R.id.av);

// Set its video options.
        mAdViewNative.setVideoOptions(new VideoOptions.Builder()
                .setStartMuted(true)
                .build());

// The VideoController can be used to get lifecycle events and info about an ad's video
// asset. One will always be returned by getVideoController, even if the ad has no video
// asset.
        mVideoController = mAdViewNative.getVideoController();
        mVideoController.setVideoLifecycleCallbacks(new VideoController.VideoLifecycleCallbacks() {
            @Override
            public void onVideoEnd() {
                Log.d(LOG_TAG, "Video playback is finished.");
                super.onVideoEnd();
            }
        });

// Set an AdListener for the AdView, so the Activity can take action when an ad has finished
// loading.
        mAdViewNative.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                if (mVideoController.hasVideoContent()) {
                    Log.d(LOG_TAG, "Received an ad that contains a video asset.");
                } else {
                    Log.d(LOG_TAG, "Received an ad that does not contain a video asset.");
                }
            }
        });

        mAdView.loadAd(new AdRequest.Builder().build());

        MobileAds.initialize(this, "ca-app-pub-8212638041206076~2499605568");

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

    public void start_btn(View view) {
        Intertialshow();
        startActivity(new Intent(this, Home.class));

    }

    public void sharebtn(View view) {
        Intertialshow();
        Intent sharingIntent = new Intent(android.content.Intent.ACTION_SEND);
        sharingIntent.setType("text/plain");
        String shareBody = "app link";
        String shareSub = "Location Tracker";
        sharingIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, shareSub);
        sharingIntent.putExtra(android.content.Intent.EXTRA_TEXT, shareBody);
        startActivity(Intent.createChooser(sharingIntent, "Share to friends using"));
    }
    @Override
    public void onBackPressed()
    {
        Intertialshow();
    }

    public void rate_us(View view) {

        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

        Intertialshow();
    }
}




