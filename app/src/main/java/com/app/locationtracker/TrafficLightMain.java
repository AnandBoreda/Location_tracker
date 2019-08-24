package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.widget.Button;

public class TrafficLightMain extends AppCompatActivity {
    Button button1 = null;
    long timeout = Long.MAX_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_traffic_light_main);
        button1 = (Button) findViewById(R.id.button1);
        button1.setBackgroundColor(Color.RED);

        change();
    }

    void change() {
        final int[] colors = {Color.GREEN, Color.YELLOW, Color.RED};
        CountDownTimer ctd = new CountDownTimer(timeout, 2000) {

            int current = 0;

            @Override
            public void onTick(long arg0) {
                Log.d("TEST", "Current color index: " + current);
                button1.setBackgroundColor(colors[current++]);
                if (current == 3)
                    current = 0;
            }

            @Override
            public void onFinish() {
            }
        };

        ctd.start();
    }
}