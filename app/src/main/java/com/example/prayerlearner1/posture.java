package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class posture extends AppCompatActivity {
    Button bins, bins1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
        bins =findViewById(R.id.button15);
        bins.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inspection();
            }
        });
        bins1=findViewById(R.id.button17);
        bins1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Demo();
            }
        });
    }
    public void inspection() {
        Intent intent=new Intent(this,posture2.class);
        startActivity(intent);
        finish();
    }
    public void Demo() {
        Intent intent=new Intent(this,posturedemo.class);
        startActivity(intent);
        finish();
    }
}