package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SugarTest extends AppCompatActivity {
    Button hlth,lvls,info,map,tst,hba1c,low,report;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sugar_test);
        hlth = findViewById(R.id.health_tips);
        lvls = findViewById(R.id.sugar_lvls);
        info = findViewById(R.id.sugar_info_btn);
        map = findViewById(R.id.bsworld_map);
        tst = findViewById(R.id.sugar_test_main);
        hba1c = findViewById(R.id.hba1c_bttn);
        low = findViewById(R.id.lowsug_bttn);
        report = findViewById(R.id.sug_report);
    }

    public void health_tips_bttn(View view) {

        startActivity(new Intent(this, HealthTips.class));
    }

    public void sugar_lvls(View view) {

        startActivity(new Intent(this, SugarLevels.class));
    }

    public void sugar_inf(View view) {

        startActivity(new Intent(this, SugarInfo.class));
    }

    public void bsmap(View view) {
        startActivity(new Intent(this, BSWorldMap.class));
    }

    public void sug_tst(View view) {
        startActivity(new Intent(this, SugarTestMain.class));
    }

    public void dbts(View view) {
        startActivity(new Intent(this, DiabetesMain.class));
    }

    public void hba1c_bttn(View view) {
        startActivity(new Intent(this, HbA1cMain.class));
    }

    public void lowsugr(View view) { startActivity(new Intent(this, LowSugar.class));
    }

    public void sugreport(View view) {
        startActivity(new Intent(this, SugReport.class));
    }
}
