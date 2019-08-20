package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Ringtones extends AppCompatActivity {
    Button ring,save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ringtones);
        ring = findViewById(R.id.ring_btn_main);
        save = findViewById(R.id.save_btn);
    }

    public void ringtone_main_btn(View view) {
        startActivity(new Intent(this, RingtonesCreate.class));
    }

    public void save_ring_btn(View view) {
        startActivity(new Intent(this, RingtonesSave.class));
    }
}
