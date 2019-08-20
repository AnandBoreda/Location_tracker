package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SugarTestMain extends AppCompatActivity {
    Button lowsug, bloodtst, ketlvl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_test_main);
        lowsug = findViewById(R.id.lowsug_bttn);
        bloodtst = findViewById(R.id.bloodtest);
        ketlvl = findViewById(R.id.testyourketonelevels);
    }

    public void lowsugarbtn(View view) {
        startActivity(new Intent(this, BloodTestMain.class));
    }

    public void bloodtestbtn(View view) {
        startActivity(new Intent(this, SugarLowMain.class));
    }

    public void ketonelvlsbtn(View view) {
        startActivity(new Intent(this, KeytonLevelsMain.class));
    }
}
