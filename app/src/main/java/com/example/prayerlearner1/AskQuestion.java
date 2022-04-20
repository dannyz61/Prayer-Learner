package com.example.prayerlearner1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class AskQuestion extends AppCompatActivity {
    DatabaseReference fbobj;
    Button btb_submit;
    EditText question;
    String uid;
    Switch identity_switch;
    FirebaseAuth fauth;
    String username;
    public long id;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ask_question);
        fbobj= FirebaseDatabase.getInstance("https://prayerlearner-default-rtdb.firebaseio.com/").getReference();
    question=findViewById(R.id.str_question);
        id=0;
        fauth=FirebaseAuth.getInstance();
        uid=fauth.getCurrentUser().getUid().toString();
        fbobj.addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(@NonNull DataSnapshot snapshot) {

              username=snapshot.child("Users").child(uid).child("name").getValue(String.class);
               id=snapshot.child("QA").getChildrenCount();
           }

           @Override
           public void onCancelled(@NonNull DatabaseError error) {

           }
       });
        identity_switch=findViewById(R.id.identity_switch);
        btb_submit=findViewById(R.id.btn_submit);
        btb_submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Date currentTime = Calendar.getInstance().getTime();
//                String time=currentTime.toString();
                SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date date = new Date();
                String time=date.toString();
                String q=question.getText().toString();

                if(identity_switch.isChecked())
                {
                    username="Anonymous";
                }
                QaModelClass obj=null;
                Log.d("Danial", "ID VALUE "+id);
                obj=new QaModelClass("",username,q,"",time,"",String.valueOf(++id));
                Log.d("Danial", "OBJ VALUE "+obj.getQuestionuid());
                 fbobj.child("QA").child(obj.getQuestionuid()).setValue(obj);
            finish();
                Intent intent=new Intent(AskQuestion.this, QASeassions.class);
                startActivity(intent);
                Toast.makeText(AskQuestion.this, "Question Uploaded. Successfully", Toast.LENGTH_SHORT).show();
            }
        });
    }
}