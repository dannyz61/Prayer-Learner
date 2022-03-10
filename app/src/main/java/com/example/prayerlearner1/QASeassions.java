package com.example.prayerlearner1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class QASeassions extends AppCompatActivity {
    Button btn_ask;
    RecyclerView qaview;
    RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Q&A");
        actionBar.setDisplayHomeAsUpEnabled(true);
        btn_ask=findViewById(R.id.btn_ask_question);

        qaview=findViewById(R.id.qarecycler);
        layoutManager=new LinearLayoutManager(this);
        qaview.setLayoutManager(layoutManager);


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

    public void askanswer(View view) {
        Intent intent=new Intent(this, Ask_Question.class);
        startActivity(intent);
    }
}