package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HealthTips extends AppCompatActivity {
    Button eff, strat, expect, body, add, infla, reason, hema, fasting;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_health_tips);
        strat = findViewById(R.id.sevenstrat);
       eff = findViewById(R.id.smokingeff);
        expect= findViewById(R.id.expectsug);
        body= findViewById(R.id.bodysug);
        add= findViewById(R.id.sugadd);
        infla= findViewById(R.id.suginfla);
        fasting= findViewById(R.id.fastsug);
        reason = findViewById(R.id.sugreason);
        hema = findViewById(R.id.sughema);

    }

    public void fasting(View view) {
        startActivity(new Intent(this, SugarFastingLevels.class));
    }

    public void hema(View view) {
        startActivity(new Intent(this, SugarHema.class));
    }

    public void reasons(View view) {
        startActivity(new Intent(this, SugarReasons.class));
    }

    public void sugarinfla(View view) {
        startActivity(new Intent(this, SugarInflamation.class));
    }

    public void sugaradd(View view) {
        startActivity(new Intent(this, SugarAddiction.class));
    }

    public void bodycontrols(View view) {
        startActivity(new Intent(this, SugarBodyControl.class));
    }

    public void sugar_inf(View view) {
        startActivity(new Intent(this, SugarInfo.class));
    }

    public void sevenstrart(View view) {
        startActivity(new Intent(this, SugarStrategies.class ));
    }

    public void smokeeff(View view) {
        startActivity(new Intent(this, SmokeEff.class));
    }
}
