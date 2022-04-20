package com.example.prayerlearner1;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;

public class QuestionDetails extends AppCompatActivity {
TextView quesview,ansview, questime,anstime,scholarname,username;
String Username;
DatabaseReference fbobj;
String id;
Button submit,back;
boolean is_scholar=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question_details);
        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Detail");
        actionBar.setDisplayHomeAsUpEnabled(true);
        Intent intent=getIntent();
        quesview=findViewById(R.id.questionview);
        ansview=findViewById(R.id.ansview);
        questime=findViewById(R.id.qtimeview);
        anstime=findViewById(R.id.anstimeview);
        scholarname=findViewById(R.id.scholar_name_view2);
        username=findViewById(R.id.user_name_view);
        submit=findViewById(R.id.submit);
        back=findViewById(R.id.back);
        quesview.setMovementMethod(new ScrollingMovementMethod());
        ansview.setMovementMethod(new ScrollingMovementMethod());




        fbobj = FirebaseDatabase.getInstance("https://prayerlearner-default-rtdb.firebaseio.com/").getReference().child("QA");

        scholarname.setText(intent.getStringExtra("scholarname"));
        username.setText(intent.getStringExtra("username"));
        anstime.setText(intent.getStringExtra("anstime"));
        questime.setText(intent.getStringExtra("questime"));
        ansview.setText(intent.getStringExtra("answer"));
        quesview.setText(intent.getStringExtra("question"));
        is_scholar=intent.getBooleanExtra("value",false);
        Username=intent.getStringExtra("name");
        id=intent.getStringExtra("id");
//        Log.d("TAG", "onCreate: " + id);
        if(is_scholar) {
           back.setVisibility(View.GONE);
        }
        else
        {
            ansview.setEnabled(false);
            submit.setVisibility(View.GONE);

        }

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
    public void back(View view) {
        Intent intent=new Intent(this, QASeassions.class);
        intent.putExtra("username",Username);
        intent.putExtra("value",true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
    }

    public void submit(View view) {
        HashMap obj=new HashMap();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        String time=date.toString();
        Log.d("TAG", "submit: "+Username + id);
        obj.put("scholarname",Username);
        obj.put("username",username.getText().toString());
        obj.put("question",quesview.getText().toString());
        obj.put("answer",ansview.getText().toString());
        obj.put("questime",questime.getText().toString());
        obj.put("anstime",time);
        fbobj.child(id).updateChildren(obj);
        Intent intent=new Intent(this, QASeassions.class);
        intent.putExtra("username",Username);
        intent.putExtra("value",true);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        finish();
        Toast.makeText(this, "Answer Uploaded", Toast.LENGTH_SHORT).show();
    }
}