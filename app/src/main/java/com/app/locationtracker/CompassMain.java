package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CompassMain extends AppCompatActivity {
    Button standard,cam,telescope,night;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass_main);
        standard = findViewById(R.id.start_button);
        cam = findViewById(R.id.camera_mode);
        telescope = findViewById(R.id.telescope_mode);
        night = findViewById(R.id.night_mode);

    }

    public void compasscam(View view) {
        startActivity(new Intent(this,CompassCamMode.class));

    }

    public void comstandard(View view) {
        startActivity(new Intent(this,CompassStandardMode.class));
    }

    public void compasstele(View view) {
        startActivity(new Intent(this,CompassTeleMode.class));
    }

    public void compassnight(View view) {
        startActivity(new Intent(this,CompassNightMode.class));
    }
}
