package com.example.find_yourself;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class About_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_activity);
        getSupportActionBar().hide();
        Bundle argument = getIntent().getExtras();
        int numberTest = argument.getInt("info");
        ArrayList<String> stringArrayList = new ArrayList<String>();

        try {
            InputStreamReader reader;
            String nameTest;

            switch (numberTest)
            {
                case 0:
                    nameTest = "about_human_nature.txt";
                    break;
                case 1:
                    nameTest = "about_human_technology.txt";
                    break;
                case 2:
                    nameTest = "about_human_human.txt";
                    break;
                case 3:
                    nameTest = "about_human_sign.txt";
                    break;
                case 4:
                    nameTest = "about_human_art.txt";
                    break;
                default:
                    nameTest = "about_app.txt";
            }

            reader = new InputStreamReader(getAssets().open(nameTest));
            BufferedReader buffer = new BufferedReader(reader);
            String lines;

            while ((lines = buffer.readLine()) != null) {
                stringArrayList.add(lines);
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        RecyclerView recyclerView = findViewById(R.id.about_rv_id);
        TextAdapter textAdapter = new TextAdapter(this, stringArrayList);
        recyclerView.setAdapter(textAdapter);
    }
}
