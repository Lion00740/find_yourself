package com.example.find_yourself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

import javax.xml.transform.Result;

public class template_for_test extends AppCompatActivity {
    ArrayList<Question> questionArrayList = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        getSupportActionBar().hide();
        getData(questionArrayList);
        RecyclerView recyclerView = findViewById(R.id.rv_id);

        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionArrayList);

        recyclerView.setAdapter(questionAdapter);

        ImageButton imageButton = findViewById(R.id.imageButton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(template_for_test.this, ResultTest.class);
                startActivity(intent);
            }
        });
    }
    public void getData(ArrayList<Question> questionArrayList)
    {
        try {
            InputStreamReader reader = new InputStreamReader(getAssets().open("test.txt"));
            BufferedReader buffer = new BufferedReader(reader);
            String lines;
            while ((lines = buffer.readLine()) != null) {
                questionArrayList.add(new Question(lines, new ArrayList<>(Arrays.asList(buffer.readLine(), buffer.readLine(), buffer.readLine(), buffer.readLine(), buffer.readLine()))));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}