package com.example.find_yourself;

import java.util.ArrayList;

public class Question {
    public String nameQuestion;
    public ArrayList<String> arrayAnswers;
    public Question(String nameQuestion, ArrayList<String> arrayAnswers)
    {
        this.nameQuestion = nameQuestion;
        this.arrayAnswers = arrayAnswers;
    }
    public String getNameQuestion() {
        return nameQuestion;
    }
    public void setNameQuestion(String nameQuestion) {
        this.nameQuestion = nameQuestion;
    }
    public String getAnswer(int position)
    {
        return arrayAnswers.get(position);
    }
}