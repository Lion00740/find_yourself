package com.example.find_yourself;

import android.os.Bundle;
import android.widget.ProgressBar;
import androidx.appcompat.app.AppCompatActivity;

public class ResultTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        getSupportActionBar().hide();

        ProgressBar progressBar1 = findViewById(R.id.progressBar1_id);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2_id);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3_id);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4_id);
        ProgressBar progressBar5 = findViewById(R.id.progressBar5_id);
        progressBar2.setProgress(40);
    }
}
