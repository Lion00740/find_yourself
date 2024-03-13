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
import java.util.Arrays;

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

        holder.rb1.setText(question.getStringAnswer(0));
        holder.rb2.setText(question.getStringAnswer(1));
        holder.rb3.setText(question.getStringAnswer(2));
        holder.rb4.setText(question.getStringAnswer(3));
        holder.rb5.setText(question.getStringAnswer(4));

        setRadio(holder, questions.get(position).getState());
        holder.rb1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions.get(position).setState(0);
                questions.get(position).setAnswer(0);
                setRadio(holder, questions.get(position).getState());
            }
        });
        holder.rb2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions.get(position).setState(1);
                questions.get(position).setAnswer(1);
                setRadio(holder, questions.get(position).getState());
            }
        });
        holder.rb3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions.get(position).setState(2);
                questions.get(position).setAnswer(2);
                setRadio(holder, questions.get(position).getState());
            }
        });
        holder.rb4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions.get(position).setState(3);
                questions.get(position).setAnswer(3);
                setRadio(holder, questions.get(position).getState());
            }
        });
        holder.rb5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                questions.get(position).setState(4);
                questions.get(position).setAnswer(4);
                setRadio(holder, questions.get(position).getState());
            }
        });
    }
    private void setRadio(ViewHolder holder, int selection)
    {
        RadioButton b1 = holder.rb1;
        RadioButton b2 = holder.rb2;
        RadioButton b3 = holder.rb3;
        RadioButton b4 = holder.rb4;
        RadioButton b5 = holder.rb5;

        if(selection == 0) b1.setChecked(true);
        if(selection == 1) b2.setChecked(true);
        if(selection == 2) b3.setChecked(true);
        if(selection == 3) b4.setChecked(true);
        if(selection == 4) b5.setChecked(true);
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
    public int[] getArrayAnswer() {
        int[] mass = new int[5];

        for (Question question :
                questions) {
            mass[0] += question.getAnswer(0);
            mass[1] += question.getAnswer(1);
            mass[2] += question.getAnswer(2);
            mass[3] += question.getAnswer(3);
            mass[4] += question.getAnswer(4);
        }
        return mass;
    }
}