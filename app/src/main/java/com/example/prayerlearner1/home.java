package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class home extends AppCompatActivity {
    private static int Splash_Time_out=3000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent home = new Intent(home.this, MainActivity.class);
                startActivity(home);
                finish();
            }
        }, Splash_Time_out);

    }
}