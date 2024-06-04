package com.example.bmicalculater;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        EditText edtWeight,edtHeightFT, edtHeightIN;
        TextView txtResult;
        Button button;
        LinearLayout llmain;
        edtWeight=findViewById(R.id.editWeight);
        edtHeightFT=findViewById(R.id.editHeightFT);
        edtHeightIN=findViewById(R.id.editHeightIN);
        button=findViewById(R.id.button);
        txtResult=findViewById(R.id.textResult);
        llmain=findViewById(R.id.main);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int wt=Integer.parseInt(edtWeight.getText().toString());
                int ft=Integer.parseInt(edtHeightFT.getText().toString());
                int in=Integer.parseInt(edtHeightIN.getText().toString());
                int totalIn= ft * 12 + in;
                double totalCm= totalIn * 2.53;
                double totalM= totalCm/100;
                double BMI= wt/(totalM * totalM);
                if(BMI>25){
                    txtResult.setText("You're Overweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.red));
                }
                else if(BMI<18){
                    txtResult.setText("You're Underweight!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.yellow));
                }
                else {
                    txtResult.setText("You're Healthy!");
                    llmain.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}