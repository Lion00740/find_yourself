package com.example.find_yourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class template_for_test extends AppCompatActivity {
    ArrayList<Question> questionArrayList = new ArrayList<Question>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.test);
        getSupportActionBar().hide();

        RecyclerView recyclerView = findViewById(R.id.rv_id);

        Bundle argument = getIntent().getExtras();
        int numberOfNextTest = argument.getInt("first_test");

        getData(questionArrayList, numberOfNextTest);

        QuestionAdapter questionAdapter = new QuestionAdapter(this, questionArrayList);

        recyclerView.setAdapter(questionAdapter);

        Button button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(template_for_test.this, ResultTest.class);

                intent.putExtra("result", questionAdapter.getArrayAnswer());
                intent.putExtra("size", questionArrayList.size());
                intent.putExtra("numberTest", numberOfNextTest);

                startActivity(intent);
            }
        });
    }
    public void getData(ArrayList<Question> questionArrayList, int numberTest)
    {
        try {
            InputStreamReader reader;
            String nameTest;

            switch (numberTest)
            {
                case 0:
                    nameTest = "human_nature.txt";
                    break;
                case 1:
                    nameTest = "human_technology.txt";
                    break;
                case 2:
                    nameTest = "human_human.txt";
                    break;
                case 3:
                    nameTest = "human_sign.txt";
                    break;
                case 4:
                    nameTest = "human_art.txt";
                    break;
                default:
                    nameTest = "test.txt";
            }

            reader = new InputStreamReader(getAssets().open(nameTest));
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