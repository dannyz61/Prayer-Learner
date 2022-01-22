package com.example.prayerlearner1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toolbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
 DrawerLayout drawer;

    private CardView c1,c2,c3,c4,c5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
    public void onBackPressed() {
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        }
        else {
            super.onBackPressed();
        }
    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card1:i=new Intent(this, posture.class);startActivity(i);
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