package com.example.find_yourself;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;

public class Tests extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tests);
        Button test1 = findViewById(R.id.test1);
        Button go_back = findViewById(R.id.go_back);
    }
}