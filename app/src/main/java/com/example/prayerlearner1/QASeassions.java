package com.example.prayerlearner1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class QASeassions extends AppCompatActivity  {
    Button btn_ask;
    RecyclerView qaview;
    RecyclerView.LayoutManager layoutManager;
    ArrayList<QaModelClass>qlist;
    DatabaseReference fbobj;
 MyQuestionAdapter myadapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qa);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Q&A");
        actionBar.setDisplayHomeAsUpEnabled(true);
        btn_ask=findViewById(R.id.btn_ask_question);
        fbobj= FirebaseDatabase.getInstance("https://prayerlearner-default-rtdb.firebaseio.com/").getReference().child("QA");
        fbobj.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot datasnapshots:snapshot.getChildren()) {
                    QaModelClass list=datasnapshots.getValue(QaModelClass.class);
                    qlist.add(list);
                }

                myadapter=new MyQuestionAdapter(getApplicationContext(),qlist);
                qaview.setAdapter(myadapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }

        }
        );
        qlist=new ArrayList<>();
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
        Intent intent=new Intent(this, AskQuestion.class);
        startActivity(intent);
        finish();
    }


}