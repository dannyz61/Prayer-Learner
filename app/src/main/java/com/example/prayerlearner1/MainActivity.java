package com.example.prayerlearner1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CardView c1,c2,c3,c4,c5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //test


        c1 = (CardView) findViewById(R.id.card1);
        c2 = (CardView) findViewById(R.id.card2);
        c3 = (CardView) findViewById(R.id.card3);
        c4 = (CardView) findViewById(R.id.card4);
        c5 = (CardView) findViewById(R.id.card5);

        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        //

    }


    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card1:i=new Intent(this, posture1.class);startActivity(i);
            break;
            case R.id.card2:i=new Intent(this, Qibladirection.class);startActivity(i);
                break;
            case R.id.card3:i=new Intent(this, QA.class);startActivity(i);
                break;
            case R.id.card4:i=new Intent(this, alerts.class);startActivity(i);
                break;
            case R.id.card5:i=new Intent(this, Report.class);startActivity(i);
                break;
        }

    }
}