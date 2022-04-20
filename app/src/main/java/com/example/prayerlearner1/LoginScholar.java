package com.example.prayerlearner1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class LoginScholar extends AppCompatActivity {
    DatabaseReference fbobj;
    TextView email,password;
    boolean is_schoolar;
    String username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_scholar);
        email=findViewById(R.id.text1);
        password=findViewById(R.id.text3);


    }

    public void log_in_as_User(View view) {
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    public void login(View view) {
        String email_str=email.getText().toString();
        String password_str=password.getText().toString();
        fbobj= FirebaseDatabase.getInstance("https://prayerlearner-default-rtdb.firebaseio.com/").getReference().child("Admin");
        fbobj.addListenerForSingleValueEvent(new ValueEventListener() {
         @Override
         public void onDataChange(@NonNull DataSnapshot snapshot) {
             for (DataSnapshot datasnapshots:snapshot.getChildren()) {
                 boolean l=email_str.equals(datasnapshots.child("email").getValue().toString());
//                 Log.d("TAG", "onDataChange: "+datasnapshots.child("email").getValue()+email_str+datasnapshots.child("password").getValue()+l);
                if( email_str.equals(datasnapshots.child("email").getValue().toString()) && password_str.equals(datasnapshots.child("password").getValue().toString()))
                {
                    username=datasnapshots.child("name").getValue().toString();
                    Log.d("TAG", "onDataChange: "+username);
                    Intent intent=new Intent(LoginScholar.this,QASeassions.class);
                    intent.putExtra("value",true);
                    intent.putExtra("username",username);
                    startActivity(intent);
                    finish();
                    is_schoolar=true;
                    Toast.makeText(LoginScholar.this, "Login Succesfully", Toast.LENGTH_SHORT).show();
                }
             }
             if (!is_schoolar)
             Toast.makeText(LoginScholar.this, "Invalid Login", Toast.LENGTH_SHORT).show();
    
         }
    
         @Override
         public void onCancelled(@NonNull DatabaseError error) {
    
         }
    
     }
        );
       
    }
}