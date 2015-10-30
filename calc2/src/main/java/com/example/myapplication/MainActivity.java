package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edit1, edit2;
    Button btnAdd, btnSub, btnMul, btnDiv;
    TextView textResult;
    String num1, num2;
    Double result;
    Button[] numButtons = new Button[10];
    Integer[] numBtnIDs = {R.id.num0,R.id.num1,R.id.num2,R.id.num3,R.id.num4,R.id.num5,R.id.num6,R.id.num7,R.id.num8,R.id.num9,};
    int i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("그리드레이아웃 계산기");

        edit1 = (EditText) findViewById(R.id.edit1);
        edit2 = (EditText) findViewById(R.id.edit2);
        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnMul = (Button) findViewById(R.id.btnMul);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        textResult = (TextView) findViewById(R.id.textResult);

        for(i = 0; i < numBtnIDs.length; i++)
            numButtons[i] = (Button) findViewById(numBtnIDs[i]);

        for(i = 0; i < numBtnIDs.length; i++) {
            final int index;
            index = i;

            numButtons[index].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (edit1.isFocused() == true) {
                        num1 = edit1.getText().toString() + numButtons[index].getText().toString();
                        edit1.setText(num1);
                    } else if (edit2.isFocused() == true) {
                        num2 = edit2.getText().toString() + numButtons[index].getText().toString();
                        edit2.setText(num2);
                    }
                }
            });
        }



        btnAdd.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(edit1.getText().toString().equals("") || edit2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) + Double.parseDouble(num2);
                    textResult.setText("계산 결과 :  " + result.toString());
                }
                return false;
            }
        });
        btnSub.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(edit1.getText().toString().equals("") || edit2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) - Double.parseDouble(num2);
                    textResult.setText("계산 결과 :  " + result.toString());
                }
                return false;
            }
        });
        btnMul.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(edit1.getText().toString().equals("") || edit2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) * Double.parseDouble(num2);
                    textResult.setText("계산 결과 :  " + result.toString());
                }
                return false;
            }
        });
        btnDiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if(edit1.getText().toString().equals("") || edit2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                else if(Double.parseDouble(num1) == 0 || Double.parseDouble(num2) == 0)
                    Toast.makeText(getApplicationContext(), "0을 나누거나 0으로 나눌수 없습니다.", Toast.LENGTH_SHORT).show();
                else {
                    num1 = edit1.getText().toString();
                    num2 = edit2.getText().toString();
                    result = Double.parseDouble(num1) / Double.parseDouble(num2);
                    textResult.setText("계산 결과 :  " + result.toString());
                }
                return false;
            }
        });
    }
}
