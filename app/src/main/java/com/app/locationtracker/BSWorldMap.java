package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BSWorldMap extends AppCompatActivity {
    Button sugmap,deathmap,top;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bsworld_map);

        sugmap = findViewById(R.id.worldmap);
        deathmap = findViewById(R.id.deathworldmap);
        top = findViewById(R.id.top5Countries);

    }

    public void sugarmap(View view) {
        startActivity(new Intent(this, SugarMapMain.class));
    }

    public void deathmap(View view) {
        startActivity(new Intent(this, SugMapDeathMain.class));
    }

    public void topcoun(View view) {
        startActivity(new Intent(this, SugTopCoubtries.class));
    }
}
