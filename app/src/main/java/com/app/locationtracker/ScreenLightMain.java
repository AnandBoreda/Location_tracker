package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ScreenLightMain extends AppCompatActivity {
    Button on;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_light_main);
        on = findViewById(R.id.whitebtn);
    }

    public void whitebtn(View view) {
        startActivity(new Intent(this, ScreenLight.class));
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}
