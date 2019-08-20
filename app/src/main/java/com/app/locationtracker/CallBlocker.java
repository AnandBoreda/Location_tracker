package com.app.locationtracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class CallBlocker extends AppCompatActivity {
    Button newnum,rec_calls,contactsbut,blklist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_call_blocker);
        newnum = findViewById(R.id.add_new);
        rec_calls = findViewById(R.id.from_call_logs);
        contactsbut = findViewById(R.id.from_contacts);
        blklist = findViewById(R.id.blocked_list);

    }

    public void newnum(View view) {
        startActivity(new Intent(this, NewNumBlock.class));

    }

    public void fromconblk(View view) {
        startActivity(new Intent(this, BlockFromCon.class));
    }

    public void fromlogs(View view) {
        startActivity(new Intent(this, BlockFromLogs.class));
    }

    public void blklist(View view) {
        startActivity(new Intent(this, BlockedList.class));
    }
}
