package com.example.prayerlearner1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Html;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.prayerlearner1.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class ForgotPassword extends AppCompatActivity {

    ConstraintLayout layout;
    Button reset;
    FirebaseAuth fauth;
    EditText email;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);;
        fauth = FirebaseAuth.getInstance();
        reset=findViewById(R.id.button2);
        email=findViewById(R.id.email_reset);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Forgot Password");
        getSupportActionBar().setTitle(Html.fromHtml("<font color=\"#FFFFFF\">" + getString(R.string.app_name) + "</font>"));
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#002028")));
        actionBar.setDisplayHomeAsUpEnabled(true);
        actionBar.setHomeAsUpIndicator(R.drawable.ic_baseline_arrow_back_24);
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

    public void reset(View view) {
        String email1=email.getText().toString();
        fauth.sendPasswordResetEmail(email1).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(ForgotPassword.this, "Reset Link has been sent to your Email Address.", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    Toast.makeText(ForgotPassword.this, "Failed to send link.", Toast.LENGTH_SHORT).show();

                }
            }
        });
    startActivity(new Intent(ForgotPassword.this, ForgotPasswordTwo.class));
    }
}