package com.example.find_yourself;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private ArrayList<Question> questions;
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.template_for_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionAdapter.ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.textView.setText(question.getNameQuestion());
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.question_id);
            RadioGroup radioGroup = itemView.findViewById(R.id.radiogroup_id);
        }
    }
}
