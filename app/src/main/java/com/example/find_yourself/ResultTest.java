package com.example.find_yourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultTest extends AppCompatActivity {
    int maxProgress = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        getSupportActionBar().hide();

        Bundle arguments = getIntent().getExtras();
        int[] result = arguments.getIntArray("result");
        int sizeTest = arguments.getInt("size");

        TextView textView1 = findViewById(R.id.textView1_id);
        TextView textView2 = findViewById(R.id.textView2_id);
        TextView textView3 = findViewById(R.id.textView3_id);
        TextView textView4 = findViewById(R.id.textView4_id);
        TextView textView5 = findViewById(R.id.textView5_id);

        Button buttonNext = findViewById(R.id.nextStage_id);

        textView1.setText(getString(R.string.human_technology));
        textView2.setText(getString(R.string.human_human));
        textView3.setText(getString(R.string.human_nature));
        textView4.setText(getString(R.string.human_sign));
        textView5.setText(getString(R.string.human_art));

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultTest.this, template_for_test.class);
                intent.putExtra("first_test", maxProgress);
                startActivity(intent);
            }
        });

        ProgressBar progressBar1 = findViewById(R.id.progressBar1_id);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2_id);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3_id);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4_id);
        ProgressBar progressBar5 = findViewById(R.id.progressBar5_id);

        progressBar1.setProgress((int) ((result[0] / (float)sizeTest) * 100));
        progressBar2.setProgress((int) ((result[1] / (float)sizeTest) * 100));
        progressBar3.setProgress((int) ((result[2] / (float)sizeTest) * 100));
        progressBar4.setProgress((int) ((result[3] / (float)sizeTest) * 100));
        progressBar5.setProgress((int) ((result[4] / (float)sizeTest) * 100));

        for (int i = 1; i < result.length; i++)
        {
            if (result[i] > result[maxProgress])
            {
                maxProgress = i;
            }
        }

    }
}