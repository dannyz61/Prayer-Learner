package com.example.prayerlearner1;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.firebase.auth.FirebaseAuth;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
 DrawerLayout drawer;
    Button logout;
    FirebaseAuth fauth;

    private CardView c1,c2,c3,c4,c5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        c1 = (CardView) findViewById(R.id.card1);
        c2 = (CardView) findViewById(R.id.card2);
        c3 = (CardView) findViewById(R.id.card3);
        c4 = (CardView) findViewById(R.id.card4);
        c5 = (CardView) findViewById(R.id.card5);
        fauth = FirebaseAuth.getInstance();

//        logout=findViewById(R.id.button16);
//        logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
//                builder.setMessage("Do you want to Logout ?");
//                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
//                    @Override
//                    public void onClick(DialogInterface dialogInterface, int i) {
//                        fauth.signOut();
//                        Intent in = new Intent(new Intent(HomeActivity.this,LoginActivity.class));
//                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
//                        finish();
//                        startActivity(in);
//                    }
//                }).setNegativeButton("No",null);
//                AlertDialog alert= builder.create();
//                alert.show();
//
//            }
//        });
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");
//        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#FFFFFF\">" + getString(R.string.app_name) + "</font>"));
//        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#002028")));
//        actionBar.setDisplayHomeAsUpEnabled(true);
//        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        //

    }

//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.navigation_drawer,menu);
//        for (int k=0;k<menu.size();k++)
//        {
//            MenuItem menuItem=menu.getItem(k);
//            SpannableString spannableString=new SpannableString(
//                    menu.getItem(k).getTitle().toString()
//            );
//            spannableString.setSpan(new ForegroundColorSpan(Color.WHITE),0,spannableString.length(),0);
//            menuItem.setTitle(spannableString);
//        }
//        return true;
//    }

//    @Override
//    public void onBackPressed() {
//        if(drawer.isDrawerOpen(GravityCompat.START)){
//            drawer.closeDrawer(GravityCompat.START);
//        }
//        else {
//            super.onBackPressed();
//        }
//    }

    @Override
    public void onClick(View view) {
        Intent i;

        switch (view.getId()){
            case R.id.card1:i=new Intent(this, PostureIdentitifiction.class);startActivity(i);
            break;
            case R.id.card2:i=new Intent(this, QiblaDirection.class);startActivity(i);
                break;
            case R.id.card3:i=new Intent(this, QASeassions.class);startActivity(i);
                break;
            case R.id.card4:i=new Intent(this, NamazAhadithAlerts.class);startActivity(i);
                break;
            case R.id.card5:i=new Intent(this, GenrateReport.class);startActivity(i);
                break;
        }

    }

}