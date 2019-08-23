package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ScreenLight extends AppCompatActivity {
    Button a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_light);
        a = findViewById(R.id.scronbtn);
    }

    public void scronbtn(View view) {
        startActivity(new Intent(this, ScreenLightMain.class));
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }

}
