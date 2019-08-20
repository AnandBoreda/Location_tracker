package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MobileLocator extends AppCompatActivity {
    Button locator,std_codes,call_block,isd_codes_btn,loc_settings,loc_report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mobile_locator);
        locator = findViewById(R.id.health_tips);
        isd_codes_btn = findViewById(R.id.isd_codes);
        loc_settings = findViewById(R.id.hba1c_bttn);
        std_codes = findViewById(R.id.bsworld_map);
        call_block = findViewById(R.id.sugar_lvls);
        loc_report = findViewById(R.id.sug_report);

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
        startActivity(new Intent(this, LocSettings.class));
    }

    public void report(View view) {
        startActivity(new Intent(this, LocReport.class));
    }
}
