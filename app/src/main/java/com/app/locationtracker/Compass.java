package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Compass extends AppCompatActivity {
    Button compass,report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        compass = findViewById(R.id.compass_btn);
        report = findViewById(R.id.report_btn);
    }

    public void compassmain(View view) {
        startActivity(new Intent(this, CompassMain.class));
    }

    public void compassreport(View view) {
        startActivity(new Intent(this, SugReport.class));
    }
}
