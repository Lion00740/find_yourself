package com.example.find_yourself;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultTest extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);
        getSupportActionBar().hide();

        Bundle arguments = getIntent().getExtras();
        int result = Integer.parseInt(arguments.get("result").toString());

        TextView textView1 = findViewById(R.id.textView1_id);
        TextView textView2 = findViewById(R.id.textView2_id);
        TextView textView3 = findViewById(R.id.textView3_id);
        TextView textView4 = findViewById(R.id.textView4_id);
        TextView textView5 = findViewById(R.id.textView5_id);

        Button buttonNext = findViewById(R.id.nextStage_id);

        switch (result)
        {
            case 1:
                textView1.setText(getString(R.string.biology));
                textView2.setText(getString(R.string.farmer));
                textView3.setText(getString(R.string.veterinarian));
                textView4.setText(getString(R.string.phytopathologist));
                textView5.setText(getString(R.string.microbiologist));
                break;
            case 2:
                textView1.setText(getString(R.string.biology));
                textView2.setText(getString(R.string.farmer));
                textView3.setText(getString(R.string.veterinarian));
                textView4.setText(getString(R.string.phytopathologist));
                textView5.setText(getString(R.string.microbiologist));
                break;
            case 3:
                textView1.setText(getString(R.string.biology));
                textView2.setText(getString(R.string.farmer));
                textView3.setText(getString(R.string.veterinarian));
                textView4.setText(getString(R.string.phytopathologist));
                textView5.setText(getString(R.string.microbiologist));
                break;
            case 4:
                textView1.setText(getString(R.string.biology));
                textView2.setText(getString(R.string.farmer));
                textView3.setText(getString(R.string.veterinarian));
                textView4.setText(getString(R.string.phytopathologist));
                textView5.setText(getString(R.string.microbiologist));
                break;
            case 5:
                textView1.setText(getString(R.string.biology));
                textView2.setText(getString(R.string.farmer));
                textView3.setText(getString(R.string.veterinarian));
                textView4.setText(getString(R.string.phytopathologist));
                textView5.setText(getString(R.string.microbiologist));
                break;
            default:
                textView1.setText(getString(R.string.human_technology));
                textView2.setText(getString(R.string.human_human));
                textView3.setText(getString(R.string.human_nature));
                textView4.setText(getString(R.string.human_sign));
                textView5.setText(getString(R.string.human_art));
                break;
        }

        buttonNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ResultTest.this, template_for_test.class);
                intent.putExtra("first_test", "5");
                startActivity(intent);
            }
        });

        ProgressBar progressBar1 = findViewById(R.id.progressBar1_id);
        ProgressBar progressBar2 = findViewById(R.id.progressBar2_id);
        ProgressBar progressBar3 = findViewById(R.id.progressBar3_id);
        ProgressBar progressBar4 = findViewById(R.id.progressBar4_id);
        ProgressBar progressBar5 = findViewById(R.id.progressBar5_id);
        progressBar2.setProgress(40);
    }
}
