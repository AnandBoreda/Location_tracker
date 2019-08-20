package com.app.locationtracker;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class Splash extends Activity {
    private Handler hand = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash);

            hand.postDelayed(new Runnable() {
                                 @Override
                                 public void run() {
                                     Intent i = new Intent(Splash.this, MainActivity.class);
                                     startActivity(i);

                                 }
                             },1000);


        }
        }
