package com.example.unitconverter;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText weight;
    private TextView information;
    private EditText height;

    @SuppressLint({"SetTextI18n", "DefaultLocale"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        weight = findViewById(R.id.bmi_weight);
        height = findViewById(R.id.bmi_height);
        Button button = findViewById(R.id.button);
        information = findViewById(R.id.bmi_information);
        button.setOnClickListener(view -> {
            Toast.makeText(MainActivity.this, "BMI is Calculated!!", Toast.LENGTH_SHORT).show();
            String str_weight = weight.getText().toString();
            float inputWeight = Float.parseFloat(str_weight);
            String str_height = height.getText().toString();
            float inputHeight = Float.parseFloat(str_height)/100;
            float bmiValue = inputWeight/(inputHeight*inputHeight);

            if (bmiValue >= 30 ){
                information.setText("Your Body mass index is " + String.format("%.2f",bmiValue)+" and you are obese");//Obese
            }
            else if (bmiValue >= 25){
                information.setText("Your Body mass index is " + String.format("%.2f",bmiValue)+" and you are overweight");//Overweight
            }
            else if (bmiValue >= 18.5){
                information.setText("Your Body mass index is " + String.format("%.2f",bmiValue)+" and you are normal");//normal
            }
            else{
                information.setText("Your Body mass index is " + String.format("%.2f",bmiValue)+" and you are underweight");//Underweight
            }
        });
    }
}