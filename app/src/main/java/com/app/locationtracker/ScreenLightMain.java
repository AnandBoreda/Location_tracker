package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

public class ScreenLightMain extends AppCompatActivity {
    Button on,off;
    RelativeLayout r;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_light_main);
        on = findViewById(R.id.whitebtn);
        r = findViewById(R.id.bgwhite);
        off = findViewById(R.id.blackbtn);
        if (on.isShown() &&  off.isShown()){
            on.setVisibility(View.VISIBLE);
        }
    }
    public void whitebtn(View view) {
        r.setBackgroundResource(R.color.white);
        on.setVisibility(View.INVISIBLE);
        off.setVisibility(View.VISIBLE);
    }
    public void blackbtn(View view) {
        r.setBackgroundResource(R.drawable.shadow);
        off.setVisibility(View.INVISIBLE);
        on.setVisibility(View.VISIBLE);
    }
    @Override
    public void onBackPressed()
    {
        super.onBackPressed();
        this.finish();
    }
}
