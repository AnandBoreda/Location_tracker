package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.util.Log;
import android.view.View;

public class ColorLightMain extends AppCompatActivity {
    private static View myView = null;
    long timeout = Long.MAX_VALUE;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_light_main);
        myView =  findViewById(R.id.my_view);
        myView.setBackgroundColor(Color.RED);// set initial colour
       change();
    }
    void change() {
        final int[] colors = {Color.GREEN, Color.YELLOW, Color.RED,Color.BLACK,Color.BLUE, Color.CYAN, Color.MAGENTA,Color.GRAY};
        CountDownTimer ctd = new CountDownTimer(timeout, 2000) {

            int current = 0;

            @Override
            public void onTick(long arg0) {
                Log.d("TEST", "Current color index: " + current);
                myView.setBackgroundColor(colors[current++]);
                if (current == 8)
                    current = 0;
            }

            @Override
            public void onFinish() {
            }
        };

        ctd.start();
    }
}