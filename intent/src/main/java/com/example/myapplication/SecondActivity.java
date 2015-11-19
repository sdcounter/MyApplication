package com.example.myapplication;


import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SecondActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.second);
        setTitle("Second 액티비티");

        Intent inIntent = getIntent();
        String calc = (inIntent.getStringExtra("Calc"));
        int result = 0;

        if(calc.equals("+")) {
            result = inIntent.getIntExtra("Num1", 0) + inIntent.getIntExtra("Num2", 0);
        } else if(calc.equals("-")) {
            result = inIntent.getIntExtra("Num1", 0) - inIntent.getIntExtra("Num2", 0);
        } else if(calc.equals("*")) {
            result = inIntent.getIntExtra("Num1", 0) * inIntent.getIntExtra("Num2", 0);
        } else if(calc.equals("/")) {
            result = inIntent.getIntExtra("Num1", 0) / inIntent.getIntExtra("Num2", 0);
        }

        final int resultValue = result;
        Button btnBack = (Button) findViewById(R.id.btnBack);
        btnBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent outIntent = new Intent(getApplicationContext(), MainActivity.class);
                outIntent.putExtra("Result", resultValue);
                setResult(RESULT_OK, outIntent);
                finish();
            }
        });

    }

}
