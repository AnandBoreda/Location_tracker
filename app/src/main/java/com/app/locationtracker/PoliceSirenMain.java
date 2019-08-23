package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class PoliceSirenMain extends AppCompatActivity {
    Handler color = new Handler();
    ImageView red,blue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_siren_main);
        red = findViewById(R.id.colorred);
        blue = findViewById(R.id.colorblue);


        for (int k = 1; k < 100; k++) {
            for (int i = 1; i < 2; i++) {
                for (int j = 1; j < 2; j++) {
                    color.postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            blue.setVisibility(View.VISIBLE);
                            red.setVisibility(View.INVISIBLE);

                        }
                    }, 500);
                }
                red.setVisibility(View.VISIBLE);
                blue.setVisibility(View.INVISIBLE);
            }
        }
    }
}
