package com.example.jtqiu.mysecondandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent from = getIntent();
        Bundle extras = from.getExtras();

        if(!extras.isEmpty()) {
            String userInput = extras.getString("userInput");
            TextView textView = (TextView)findViewById(R.id.textView);
            textView.setText(userInput);
        }
    }
}
