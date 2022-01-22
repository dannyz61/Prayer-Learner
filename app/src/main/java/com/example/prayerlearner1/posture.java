package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class posture extends AppCompatActivity {
    Button bins1, bins2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
        bins1 = findViewById(R.id.button15);
        bins2 = findViewById(R.id.button17);
        bins1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                inspection();
            }
        });
        bins2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                demo();
            }
        });

    }
    public void inspection() {
        Intent intent=new Intent(this,postureInspection.class);
        startActivity(intent);
        finish();
    }
    public void demo() {
        Intent intent=new Intent(this,posturedemo.class);
        startActivity(intent);
        finish();
    }
}