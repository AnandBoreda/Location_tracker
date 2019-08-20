package com.app.locationtracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class Home extends AppCompatActivity {
    Button button_sugar_test, button_compass, button_loc, button_ringtones, button_flash_tools;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        button_sugar_test = findViewById(R.id.lowsug_bttn);
        button_compass = findViewById(R.id.compass_btn);
        button_loc = findViewById(R.id.loc_btn);
        button_ringtones = findViewById(R.id.ring_btn);
        button_flash_tools = findViewById(R.id.flash_btn);
            }

    public void sugar_test(View view) {
        startActivity(new Intent(this, SugarTest.class));
    }

    public void compass(View view) {
        startActivity(new Intent(this, Compass.class));
    }

    public void loc_tracker(View view) {
        startActivity(new Intent(this, MobileLocator.class));
    }

    public void ringtones(View view) {
        startActivity(new Intent(this, Ringtones.class));

    }

    public void flash_tools(View view) {
        startActivity(new Intent(this, FlashTools.class));
    }
}