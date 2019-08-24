package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class NewNumBlock extends AppCompatActivity {
   EditText number;
   static  String n;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_num_block);
        number = findViewById(R.id.textValue);
        n = number.getText().toString();

    }

  public void numpass(View view) {
       Intent i = new Intent(getApplicationContext(), BlockedList.class);
        i.putExtra("number",n);
        startActivity(i);

      Bundle b = new Bundle();
      b.putString("numb", n);
      i.putExtras(b);
      startActivity(i);
      Toast.makeText(getBaseContext(),"An error occured",Toast.LENGTH_SHORT).show();

  }


}
