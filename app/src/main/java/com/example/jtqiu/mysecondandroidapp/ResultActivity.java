package com.example.jtqiu.mysecondandroidapp;

import android.content.Intent;
import android.support.annotation.BinderThread;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ResultActivity extends AppCompatActivity {
    @Bind(R.id.textView) TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        ButterKnife.bind(this);

        Intent from = getIntent();
        Bundle extras = from.getExtras();

        if(!extras.isEmpty()) {
            String userInput = extras.getString("userInput");
            textView.setText(userInput);
        }
    }
}
