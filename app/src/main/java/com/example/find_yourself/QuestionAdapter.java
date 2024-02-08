package com.example.find_yourself;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class QuestionAdapter extends RecyclerView.Adapter<QuestionAdapter.ViewHolder>{
    private LayoutInflater inflater;
    private ArrayList<Question> questions;
    QuestionAdapter(Context context, ArrayList<Question> questionArrayList)
    {
        this.inflater = LayoutInflater.from(context);
        this.questions = questionArrayList;
    }
    @Override
    public QuestionAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.template_for_question, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(QuestionAdapter.ViewHolder holder, int position) {
        Question question = questions.get(position);
        holder.textView.setText(question.getNameQuestion());

        holder.rb1.setText(question.getAnswer(0));
        holder.rb2.setText(question.getAnswer(1));
        holder.rb3.setText(question.getAnswer(2));
        holder.rb4.setText(question.getAnswer(3));
        holder.rb5.setText(question.getAnswer(4));
    }

    @Override
    public int getItemCount() {
        return questions.size();
    }
    public static class ViewHolder extends RecyclerView.ViewHolder {
        final TextView textView;
        public RadioGroup radioGroup;
        public RadioButton rb1, rb2, rb3, rb4, rb5;
        public ViewHolder(View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.question_id);
            radioGroup = itemView.findViewById(R.id.radiogroup_id);

            rb1 = itemView.findViewById(R.id.rb1_id);
            rb2 = itemView.findViewById(R.id.rb2_id);
            rb3 = itemView.findViewById(R.id.rb3_id);
            rb4 = itemView.findViewById(R.id.rb4_id);
            rb5 = itemView.findViewById(R.id.rb5_id);
        }
    }

    public void addQuestion(Question question)
    {
        questions.add(question);
        notifyDataSetChanged();
    }
}
