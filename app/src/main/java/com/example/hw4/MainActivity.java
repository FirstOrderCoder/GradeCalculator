package com.example.hw4;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity
{

    int test_1_score, test_2_score, total, selectedId;
    String letter_grade, t1Value, t2Value;
    Bundle extras = new Bundle();
    EditText test_1_input, test_2_input;
    RadioGroup rg;
    Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        test_1_input =  (EditText) findViewById(R.id.test1_input);
        test_2_input =  (EditText) findViewById(R.id.test2_input);
        rg = (RadioGroup) findViewById(R.id.radioGroup);
        calculateButton = (Button) findViewById(R.id.calculate);

        calculateButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                t1Value = test_1_input.getText().toString();
                test_1_score = Integer.parseInt(t1Value);
                t2Value = test_2_input.getText().toString();
                test_2_score = Integer.parseInt(t2Value);

                int selectedId = rg.getCheckedRadioButtonId();
                if (selectedId==R.id.undergrad) {
                    total = (int) ((test_1_score* .30)+(test_2_score* .70));
                }
                else if (selectedId==R.id.grad) {
                    total = (int) ((test_1_score* .50)+(test_2_score* .50));
                }
                if (total <= 100 && total >= 90 ) {
                    letter_grade = "A";
                }
                else if (total <= 89 && total >= 80) {
                    letter_grade = "B";
                }
                else if(total <= 79 && total >= 75) {
                    letter_grade = "C";

                }
                else if(total <= 74 && total >= 70) {
                    letter_grade = "D";
                }
                else {
                    letter_grade = "F";
                }

                extras.putString("LETTER_GRADE",letter_grade);

                Intent i = new Intent(getApplicationContext(), grade_results.class);
                i.putExtras(extras);
                startActivity(i);
            }
        });


    }

}



    /*public void buttonOnClick(View v) {
        test_1_input =  (EditText) findViewById(R.id.test1_input);
        String t1Value = test_1_input.getText().toString();
        test_1_score = Integer.parseInt(t1Value);

        test_2_input =  (EditText) findViewById(R.id.test2_input);
        String t2Value = test_2_input.getText().toString();
        test_2_score = Integer.parseInt(t2Value);

        RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup);
        int selectedId = rg.getCheckedRadioButtonId();

        if (selectedId==R.id.undergrad) {
            total = (int) ((test_1_score* .30)+(test_2_score* .70));
        }
        else if (selectedId==R.id.grad) {
            total = (int) ((test_1_score* .50)+(test_2_score* .50));
        }
        if (total <= 100 && total >= 90 ) {
            letter_grade = "A";
        }
        else if (total <= 89 && total >= 80) {
            letter_grade = "B";
        }
        else if(total <= 79 && total >= 75) {
            letter_grade = "C";

        }
        else if(total <= 74 && total >= 70) {
            letter_grade = "D";
        }
        else {
            letter_grade = "F";
        }*/


    //}
