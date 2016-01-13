package com.example.jtqiu.mysecondandroidapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class UserProfileActivity extends AppCompatActivity {

    @Bind(R.id.user_profile_nickname) TextView nickName;
    @Bind(R.id.user_profile_fullname) TextView fullName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);

        ButterKnife.bind(this);

        showProfile();
    }

    private void showProfile() {
        nickName.setText("Nick: juntao");
        fullName.setText("Full: Juntao Qiu");
    }
}
