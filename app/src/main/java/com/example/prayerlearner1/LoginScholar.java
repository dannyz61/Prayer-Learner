package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class LoginScholar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_scholar);
    }

    public void log_in_as_User(View view) {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    public void login(View view) {
        Intent intent=new Intent(this,QASeassions.class);
        intent.putExtra("value",true);
        startActivity(intent);
        finish();
    }
}