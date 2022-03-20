package com.example.prayerlearner1;


import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyQuestionAdapter extends RecyclerView.Adapter<MyQuestionAdapter.MyQuestionViewHolder> {

    Context context;
    List<QaModelClass> listdata;

    public MyQuestionAdapter(Context context, List<QaModelClass> listdata) {
        this.context = context;
        this.listdata = listdata;
    }

    @NonNull
    @Override
    public MyQuestionViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.question_item_view, parent, false);
        return new MyQuestionViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyQuestionViewHolder holder, int position) {
        QaModelClass q = listdata.get(position);
        String a = q.getQuestion();
        holder.question.setText(a);


    }

    @Override
    public int getItemCount() {
        return listdata.size();
    }

    public class MyQuestionViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        EditText question;

        public MyQuestionViewHolder(@NonNull View itemView) {
            super(itemView);
            question = itemView.findViewById(R.id.single_value_question);

        }

        @Override
        public void onClick(View v) {

        }
    }

    public interface OnclickQauestionLisnter{
        void OnQuestionClick(int position);

    }

}

