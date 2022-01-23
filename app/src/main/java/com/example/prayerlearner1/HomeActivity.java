package com.example.prayerlearner1;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {
 DrawerLayout drawer;
    Button logout;
    FirebaseAuth fauth;
    DatabaseReference fobj;
    NavigationView nav;
    TextView name,email;
    String uid;
    FloatingActionButton editImage;
    Bitmap bitmap;
    ImageView imageView;
    LinearLayout L;
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
//        L=findViewById(R.id.linearLayout2);
//
//        nav=findViewById(R.id.nav_1);
//       name = L.findViewById(R.id.textView40);
        fauth = FirebaseAuth.getInstance();
//       name.setText("Hello");
//        email =L.findViewById(R.id.textView);
//        name.setText("djfkjslkjf@gamil.com");
//        editImage = findViewById(R.id.editImage);
//        imageView = findViewById(R.id.imageView);
//        uid=fauth.getCurrentUser().getUid();
//        fobj = FirebaseDatabase.getInstance("https://prayerlearner-default-rtdb.firebaseio.com/").getReference().child("Users");
//        nav.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                return false;
//            }
//        });
//        editImage.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent=new Intent();
//                intent.setType("image/*");
//                intent.setAction(Intent.ACTION_GET_CONTENT);
//                intent.addCategory(Intent.CATEGORY_OPENABLE);
//                startActivityForResult(intent,101);
//            }
//        });
//        fobj.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(@NonNull DataSnapshot snapshot) {
//                if(name.getText().toString().equals("name") && email.getText().toString().equals("some@gmail.com"))
//                {name.setText(snapshot.child(uid).child("name").getValue(String.class));
//                email.setText( snapshot.child(uid).child("email").getValue(String.class));
//                }
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError error) {
//
//            }
//        });

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Home");
        actionBar.getNavigationMode();
        c1.setOnClickListener(this);
        c2.setOnClickListener(this);
        c3.setOnClickListener(this);
        c4.setOnClickListener(this);
        c5.setOnClickListener(this);
        //

    }

    @Override
    protected void onStart() {
        super.onStart();


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                 AlertDialog.Builder builder=new AlertDialog.Builder(HomeActivity.this);
                builder.setMessage("Do you want to Logout ?");
                builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        fauth.signOut();
                        Intent in = new Intent(new Intent(HomeActivity.this,LoginActivity.class));
                        in.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                        finish();
                        startActivity(in);
                    }
                }).setNegativeButton("No",null);
                AlertDialog alert= builder.create();
                alert.show();
            default:
                return super.onOptionsItemSelected(item);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.logout,menu);
        return true;
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
//class header_vie extends AppCompatActivity
//{
//
//    FirebaseAuth fauth;
//
//
//    @Override
//    protected void onCreate(@Nullable Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.nav_header);
//
//
//    }
//
//    @Override
//    protected void onStart() {
//        super.onStart();
//
//}
