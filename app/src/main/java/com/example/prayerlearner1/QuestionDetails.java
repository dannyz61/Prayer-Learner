package com.example.prayerlearner1;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class QuestionDetails extends AppCompatActivity {
TextView quesview,ansview,questime,anstime,scholarname,username;
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

        scholarname.setText(intent.getStringExtra("scholarname"));
        username.setText(intent.getStringExtra("username"));
        anstime.setText(intent.getStringExtra("anstime"));
        questime.setText(intent.getStringExtra("questime"));
        ansview.setText(intent.getStringExtra("answer"));
        quesview.setText(intent.getStringExtra("question"));

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
        startActivity(intent);
    }
}