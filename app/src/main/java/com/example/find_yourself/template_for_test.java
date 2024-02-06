package com.example.find_yourself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class template_for_test extends Activity {
    ArrayList<Question> questionArrayList = new ArrayList<Question>();
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);

        setInitialData();

        ImageButton imageButton = findViewById(R.id.imageButton);
        ImageView imageView = findViewById(R.id.imageView);
        RecyclerView recyclerView = findViewById(R.id.rv_id);

        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionArrayList);

        recyclerView.setAdapter(questionAdapter);
    }

    private void setInitialData(){
        questionArrayList.add(new Question("привет как дела?"));

        questionArrayList.add(new Question("привет как дела?"));

        questionArrayList.add(new Question("привет как дела?"));
    }
}
