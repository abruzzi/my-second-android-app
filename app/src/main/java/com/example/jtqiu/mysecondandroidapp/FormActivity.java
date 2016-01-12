package com.example.jtqiu.mysecondandroidapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FormActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        View buttonSubmit = findViewById(R.id.buttonSubmit);
        buttonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switchToResultActivity();
                Log.e(FormActivity.class.toString(), "switch to resultview");
            }
        });
    }

    private void switchToResultActivity() {
        EditText input = (EditText)findViewById(R.id.editText);

        Bundle bundle = new Bundle();
        bundle.putString("userInput", String.valueOf(input.getText()));

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtras(bundle);

        startActivity(intent);
    }
}
