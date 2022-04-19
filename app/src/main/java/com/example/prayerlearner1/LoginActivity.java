package com.example.prayerlearner1;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class LoginActivity extends AppCompatActivity {
    FirebaseAuth fauth;
    EditText email,password;
    private ProgressBar progressbar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        fauth=FirebaseAuth.getInstance();
        email=findViewById(R.id.email_text);
        password=findViewById(R.id.password);
        progressbar=findViewById(R.id.progressBar);


    }

    @Override
    protected void onStart() {
        super.onStart();
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        if(user!=null)
        {
            startActivity(new Intent(this, HomeActivity.class));
            finish();
        }
    }

    public void Reset_password(View view) {
        startActivity(new Intent(LoginActivity.this, com.example.prayerlearner1.ForgotPassword.class));
    }

    public void signup(View view) {
        startActivity(new Intent(LoginActivity.this, com.example.prayerlearner1.Signup.class));
    }

    public void login(View view) {
        progressbar.setVisibility(View.VISIBLE);
        String email1=email.getText().toString();
        String pass=password.getText().toString();
        fauth.signInWithEmailAndPassword(email1,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
            if(task.isSuccessful())
            {
                progressbar.setVisibility(View.GONE);
                Toast.makeText(LoginActivity.this,  "Login Successful", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(LoginActivity.this,HomeActivity.class));
            }
            else
            {
                Toast.makeText(LoginActivity.this,  "Email or password is incorrect", Toast.LENGTH_SHORT).show();
            }
            }
        });
    }

    public void log_in_as_scholar(View view) {
    startActivity(new Intent(this,LoginScholar.class));
    finish();
    }
}