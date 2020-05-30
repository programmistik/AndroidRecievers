package com.example.app1;

import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.EditText;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String str = intent.getStringExtra("someData");
        try {
            MainActivity.getIns().updateText(str);
        } catch (Exception e) {
            Toast.makeText(context, "ERROR: " + e.getMessage(), Toast.LENGTH_LONG).show();
        }


    }
}
