package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FlashScreenMain extends AppCompatActivity {
    Button torch, siren, scrlight, traffic, dj, clrlight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flash_screen_main);
        torch = findViewById(R.id.torchmain);
        siren = findViewById(R.id.policelight);
        scrlight= findViewById(R.id.scrlight);
        traffic= findViewById(R.id.trafficlightbtn);
        dj = findViewById(R.id.djlightbtn);
        clrlight= findViewById(R.id.colorlightbtn);
    }

    public void siren(View view) {
        startActivity(new Intent(this, PoliceSirenMain.class));
    }

    public void torch(View view) {
        startActivity(new Intent(this, TorchMain.class));
    }

    public void screenlight(View view) {
        startActivity(new Intent(this, ScreenLightMain.class));
    }

public void trafficlight(View view) {
    startActivity(new Intent(this, TrafficLightMain.class));
    }

    public void djlight(View view) {
        startActivity(new Intent(this, DjLightsMain.class));
    }

    public void colorlight(View view) {
        startActivity(new Intent(this, ColorLightMain.class));
    }
}
