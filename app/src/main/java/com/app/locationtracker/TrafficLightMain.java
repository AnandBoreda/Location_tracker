package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class TrafficLightMain extends AppCompatActivity {
    AdView mAdView,banner,nativ;

    Button button1 = null;
    long timeout = Long.MAX_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setBackgroundColor(Color.RED);
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


        change();
    }

    void change() {
        final int[] colors = {Color.GREEN, Color.YELLOW, Color.RED};
        CountDownTimer ctd = new CountDownTimer(timeout, 2000) {

            int current = 0;

            @Override
            public void onTick(long arg0) {
                Log.d("TEST", "Current color index: " + current);
                button1.setBackgroundColor(colors[current++]);
                if (current == 3)
                    current = 0;
            }

            @Override
            public void onFinish() {
            }
        };

        ctd.start();
    }
}