package com.example.find_yourself;

import android.os.Bundle;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class About_activity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_app_text);
        getSupportActionBar().hide();

        TextView textView = findViewById(R.id.about_tv_id);

        try {
            InputStreamReader reader;
            String nameTest;
            nameTest = "about_app.txt";

            reader = new InputStreamReader(getAssets().open(nameTest));
            BufferedReader buffer = new BufferedReader(reader);
            String lines;
            StringBuffer strBuffer = new StringBuffer();

            while ((lines = buffer.readLine()) != null) {
                strBuffer.append(lines + "\n");
            }
            textView.setText(strBuffer.toString());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
