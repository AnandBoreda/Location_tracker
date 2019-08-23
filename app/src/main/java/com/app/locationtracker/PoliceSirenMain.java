package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class PoliceSirenMain extends AppCompatActivity {
    final static int INTERVAL = 200;
    private static View myView = null;
    boolean whichColor = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_police_siren_main);  myView =  findViewById(R.id.my_view);
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
                    myView.setBackgroundColor(Color.BLUE);
            }
        });
    }

}