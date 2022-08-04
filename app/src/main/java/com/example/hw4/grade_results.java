package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class grade_results extends AppCompatActivity {

    Button returnToMain;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grade_results);

        returnToMain = (Button) findViewById(R.id.button);
        returnToMain.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        String l_grade = extras.getString("LETTER_GRADE");
        TextView resultText = (TextView) findViewById(R.id.grade_letter);
        resultText.setText(l_grade);
    }

}