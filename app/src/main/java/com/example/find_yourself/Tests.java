package com.example.find_yourself;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class Tests extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tests);
        getSupportActionBar().hide();
        Button test1 = findViewById(R.id.test1);
        ImageButton imageButton = findViewById(R.id.go_back);
        test1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tests.this, template_for_test.class);
                startActivity(intent);
            }
        });
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Tests.this, Main.class);
                startActivity(intent);
            }
        });
    }
}
