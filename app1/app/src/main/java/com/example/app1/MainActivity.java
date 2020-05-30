package com.example.app1;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    public String MY_MESSAGE = "com.example.app1.CODE_APP1";
    public String text = "";
    private static MainActivity ins;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ins = this;
        setContentView(R.layout.activity_main);


        EditText editText = (EditText) findViewById(R.id.editText);

        editText.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {}

            public void beforeTextChanged(CharSequence s, int start,  int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start, int before, int count) {
                text = s.toString();

                Intent intent = new Intent();
                intent.setAction(MY_MESSAGE);
                intent.putExtra("someData", text);
                intent.addFlags(Intent.FLAG_INCLUDE_STOPPED_PACKAGES);
                sendBroadcast(intent);
            }
        });
    }

    public static MainActivity  getIns(){
        return ins;
    }

    public void updateText(String txt) {

                EditText textV1 = (EditText) findViewById(R.id.editText);
                textV1.setText(txt);

    }
}