package com.example.find_yourself;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import androidx.annotation.Nullable;

public class template_for_test extends Activity {
    short numberOfButtons = 5;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.template_test);

        ImageButton imageButton = findViewById(R.id.image_arrow1);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        RadioGroup[] radioGroups = new RadioGroup[numberOfButtons];

        radioGroups[0] = findViewById(R.id.radioGroup1);
        radioGroups[1] = findViewById(R.id.radioGroup2);
        radioGroups[2] = findViewById(R.id.radioGroup3);
        radioGroups[3] = findViewById(R.id.radioGroup4);
        radioGroups[4] = findViewById(R.id.radioGroup5);

        RadioButton[][] radioButtons = new RadioButton[numberOfButtons][numberOfButtons];

        for (int i=0; i < numberOfButtons; i++)
        {
            for(int j = 0; j < numberOfButtons; j++)
            {
                radioButtons[i][j] = new RadioButton(this);
                radioButtons[i][j].setWidth(240);
                radioButtons[i][j].setLayoutParams(new RadioGroup.LayoutParams(RadioGroup.LayoutParams.WRAP_CONTENT, RadioGroup.LayoutParams.WRAP_CONTENT));
                radioGroups[i].addView(radioButtons[i][j]);
            }
        }

    }
}
