package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlashTools extends AppCompatActivity {
    Button scr, clap, alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_tools);
        scr = findViewById(R.id.falshscrn);
        clap = findViewById(R.id.flashclap);
        alert = findViewById(R.id.flashalert);

    }

    public void flashscreen(View view) {
        startActivity(new Intent(this, FlashScreenMain.class));
    }

    public void flashalert(View view) {
        startActivity(new Intent(this, FlashClapMain.class));
    }

    public void flashclap(View view) {
        startActivity(new Intent(this, FlashAlertMain.class));
    }
}
