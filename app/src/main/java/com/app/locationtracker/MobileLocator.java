package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class MobileLocator extends AppCompatActivity {
    AdView mAdView,banner,nativ;

    Button locator,std_codes,call_block,isd_codes_btn,loc_settings,loc_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_locator);
        locator = findViewById(R.id.locmob);
        isd_codes_btn = findViewById(R.id.isd_codes);
        loc_settings = findViewById(R.id.settings);
        std_codes = findViewById(R.id.stdcodes);
        call_block = findViewById(R.id.callblock);
        loc_report = findViewById(R.id.locreport);
        //native
        MobileAds.initialize(this, new OnInitializationCompleteListener() {
            @Override
            public void onInitializationComplete(InitializationStatus initializationStatus) {
            }
        });
        nativ = findViewById(R.id.native_adView);
        AdRequest natrequest = new AdRequest.Builder().build();
        nativ.loadAd(natrequest);
//end-native
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

    }
    public void call_block(View view) {
        startActivity(new Intent(this, CallBlocker.class));
    }

    public void locator(View view) {
        startActivity(new Intent(this, Locator.class));
    }

    public void std_codes(View view) {
        startActivity(new Intent(this, STDCodes.class));
    }

    public void isd_codes(View view){
        startActivity(new Intent(this, ISDCodes.class));

    }

    public void settings(View view) {
        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void report(View view) {
        startActivity(new Intent(this, LocReport.class));
    }

    public void locad(View view) {
        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void locad1(View view) {
        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }

    public void locad2(View view) {
        String url = "https://www.google.com";
        Intent i = new Intent(Intent.ACTION_VIEW);
        i.setData(Uri.parse(url));
        startActivity(i);

    }
}
