package com.example.prayerlearner1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class PostureIdentitifiction extends AppCompatActivity {
    Button bins1, bins2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_posture);
        bins1 = findViewById(R.id.button15);
        bins2 = findViewById(R.id.button17);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Posture Identification");
        actionBar.setDisplayHomeAsUpEnabled(true);
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
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }
    public void inspection() {
        Intent intent=new Intent(this, PostureInspection.class);
        startActivity(intent);
        finish();
    }
    public void demo() {
        Intent intent=new Intent(this, PostureDemo.class);
        startActivity(intent);
        finish();
    }


    public void PostureIdentification(View view) {


        Intent intent=new Intent(this, postureIdentification.class);
        startActivity(intent);
        finish();
    }
}