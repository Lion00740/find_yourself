package com.example.find_yourself;

import java.util.ArrayList;
import java.util.Arrays;

public class Question {
    public String nameQuestion;
    public ArrayList<String> arrayAnswers;
    public int state;
    public int[] answer = new int[5];
    public Question(String nameQuestion, ArrayList<String> arrayAnswers)
    {
        this.nameQuestion = nameQuestion;
        this.arrayAnswers = arrayAnswers;
        Arrays.fill(answer, 0);
        answer[0] = 1;
    }
    public String getNameQuestion() {
        return nameQuestion;
    }
    public void setNameQuestion(String nameQuestion) {
        this.nameQuestion = nameQuestion;
    }
    public String getStringAnswer(int position)
    {
        return arrayAnswers.get(position);
    }
    public void setState(int i){
        this.state = i;
    }
    public int getState()
    {
        return this.state;
    }
    public void setAnswer(int i)
    {
        Arrays.fill(answer, 0);
        answer[i] = 1;
    }

    public int getAnswer(int i)
    {
        return answer[i];
    }
}