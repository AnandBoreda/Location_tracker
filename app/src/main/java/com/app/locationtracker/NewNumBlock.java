package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;

public class NewNumBlock extends AppCompatActivity {
   EditText number;
   static  String n;
    AdView mAdView,banner,nativ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_num_block);
        number = findViewById(R.id.textValue);
        n = number.getText().toString();
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

    }

  public void numpass(View view) {
       Intent i = new Intent(getApplicationContext(), BlockedList.class);
        i.putExtra("number",n);
        startActivity(i);

      Bundle b = new Bundle();
      b.putString("numb", n);
      i.putExtras(b);
      startActivity(i);
      Toast.makeText(getBaseContext(),"An error occured",Toast.LENGTH_SHORT).show();

  }


}
