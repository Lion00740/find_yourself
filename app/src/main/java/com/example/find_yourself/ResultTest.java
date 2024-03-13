package com.example.find_yourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class ResultTest extends AppCompatActivity {
    int maxProgress = 0;
    ArrayList<String> stringArrayList = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        getSupportActionBar().hide();
        String[] strings = new String[5];

        Bundle arguments = getIntent().getExtras();
        int[] result = arguments.getIntArray("result");
        int sizeTest = arguments.getInt("size");
        int numberTest = arguments.getInt("numberTest");

        try {
            InputStreamReader reader;
            String nameTest;
            switch (numberTest)
            {
                case 0:
                    strings[0] = getString(R.string.biology);
                    strings[1] = getString(R.string.farmer);
                    strings[2] = getString(R.string.veterinarian);
                    strings[3] = getString(R.string.phytopathologist);
                    strings[4] = getString(R.string.microbiologist);
                    nameTest = "prof_human_nature.txt";
                    break;
                case 1:
                    strings[0] = getString(R.string.mechanic);
                    strings[1] = getString(R.string.machinist);
                    strings[2] = getString(R.string.electrician);
                    strings[3] = getString(R.string.videographer);
                    strings[4] = getString(R.string.system_administrator);
                    nameTest = "prof_human_technology.txt";
                    break;
                case 2:
                    strings[0] = getString(R.string.doctor);
                    strings[1] = getString(R.string.coach);
                    strings[2] = getString(R.string.mentor);
                    strings[3] = getString(R.string.cook);
                    strings[4] = getString(R.string.policeman);
                    nameTest = "prof_human_human.txt";
                    break;
                case 3:
                    strings[0] = getString(R.string.editor);
                    strings[1] = getString(R.string.analyst);
                    strings[2] = getString(R.string.engineer);
                    strings[3] = getString(R.string.sound_producer);
                    strings[4] = getString(R.string.developer);
                    nameTest = "prof_human_sign.txt";
                    break;
                case 4:
                    strings[0] = getString(R.string.actor);
                    strings[1] = getString(R.string.travel_agent);
                    strings[2] = getString(R.string.web_designer);
                    strings[3] = getString(R.string.photographer);
                    strings[4] = getString(R.string.architect);
                    nameTest = "prof_human_art.txt";
                    break;
                default:
                    strings[0] = getString(R.string.human_nature);
                    strings[1] = getString(R.string.human_technology);
                    strings[2] = getString(R.string.human_human);
                    strings[3] = getString(R.string.human_sign);
                    strings[4] = getString(R.string.human_art);
                    nameTest = "result_info.txt";
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

        RecyclerView recyclerView = findViewById(R.id.result_text_id);

        TextAdapter textAdapter = new TextAdapter(this, stringArrayList);
        recyclerView.setAdapter(textAdapter);

        TextView textView1 = findViewById(R.id.textView1_id);
        TextView textView2 = findViewById(R.id.textView2_id);
        TextView textView3 = findViewById(R.id.textView3_id);
        TextView textView4 = findViewById(R.id.textView4_id);
        TextView textView5 = findViewById(R.id.textView5_id);

        textView1.setText(strings[0]);
        textView2.setText(strings[1]);
        textView3.setText(strings[2]);
        textView4.setText(strings[3]);
        textView5.setText(strings[4]);

        Button buttonNext = findViewById(R.id.nextStage_id);
        if(numberTest >= 0)
        {
            buttonNext.setText("На главную");
        }
        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent;
                if(numberTest == -1)
                {
                    intent = new Intent(ResultTest.this, template_for_test.class);
                    intent.putExtra("first_test", maxProgress);
                }
                else {
                    intent = new Intent(ResultTest.this, Main.class);
                }
                startActivity(intent);
            }
        });

        Button buttonCheck = findViewById(R.id.info_id);
        if(numberTest == -1)
        {
            buttonCheck.setVisibility(View.GONE);
        }
        else {
            buttonCheck.setVisibility(View.VISIBLE);
        }
        buttonCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultTest.this, About_activity.class);
                intent.putExtra("info", numberTest);
                startActivity(intent);
            }
        });

        ProgressBar progressBar1 = findViewById(R.id.progressBar1_id);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2_id);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3_id);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4_id);
        ProgressBar progressBar5 = findViewById(R.id.progressBar5_id);

        TextView procent1 = findViewById(R.id.tv_progress_horizontal1);
        TextView procent2 = findViewById(R.id.tv_progress_horizontal2);
        TextView procent3 = findViewById(R.id.tv_progress_horizontal3);
        TextView procent4 = findViewById(R.id.tv_progress_horizontal4);
        TextView procent5 = findViewById(R.id.tv_progress_horizontal5);

        progressBar1.setProgress((int) ((result[0] / (float)sizeTest) * 100));
        progressBar2.setProgress((int) ((result[1] / (float)sizeTest) * 100));
        progressBar3.setProgress((int) ((result[2] / (float)sizeTest) * 100));
        progressBar4.setProgress((int) ((result[3] / (float)sizeTest) * 100));
        progressBar5.setProgress((int) ((result[4] / (float)sizeTest) * 100));

        procent1.setText(Integer.toString((int) ((result[0] / (float)sizeTest) * 100)) + "%");
        procent2.setText(Integer.toString((int) ((result[1] / (float)sizeTest) * 100)) + "%");
        procent3.setText(Integer.toString((int) ((result[2] / (float)sizeTest) * 100)) + "%");
        procent4.setText(Integer.toString((int) ((result[3] / (float)sizeTest) * 100)) + "%");
        procent5.setText(Integer.toString((int) ((result[4] / (float)sizeTest) * 100)) + "%");

        for (int i = 0; i < result.length; i++)
        {
            if (result[i] > result[maxProgress])
            {
                maxProgress = i;
            }
        }
    }
}