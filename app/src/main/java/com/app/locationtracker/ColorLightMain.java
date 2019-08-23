package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;

public class ColorLightMain extends AppCompatActivity {
    final static int INTERVAL = 1000;
    private static View myView = null;
    boolean whichColor = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_light_main);
        myView =  findViewById(R.id.my_view);
        myView.setBackgroundColor(Color.RED);// set initial colour
        new Thread(new Runnable() {
            public void run() {
                while (true) {
                    try {
                        Thread.sleep(INTERVAL);
                    }
                    catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    updateColor();
                    whichColor = !whichColor;
                }
            }
        }).start();
    }

    private void updateColor() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (whichColor)
                    myView.setBackgroundColor(Color.RED);
                else
                    myView.setBackgroundColor(Color.GREEN);
            }
        });
    }

}
