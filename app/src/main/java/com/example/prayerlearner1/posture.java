package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Posture extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
    }

    public void gotoposturecorrection(View view) {
        Intent intent=new Intent(this,posture2.class);
        startActivity(intent);
        finish();
    }
    public void opendemo(View view) {
        Intent intent=new Intent(this,postureDemo.class);
        startActivity(intent);
        finish();
    }
}