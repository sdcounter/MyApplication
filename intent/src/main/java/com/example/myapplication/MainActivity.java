package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("메인 액티비티");

        final EditText edtNum1 = (EditText) findViewById(R.id.edtNum1);
        final EditText edtNum2 = (EditText) findViewById(R.id.edtNum2);
        final RadioGroup rdGroup = (RadioGroup) findViewById(R.id.rdGroup);


        Button btnNewActivity = (Button) findViewById(R.id.btnNewActivity);
        btnNewActivity.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), SecondActivity.class);

                if(edtNum1.getText().toString().equals("") || edtNum2.getText().toString().equals(""))
                    Toast.makeText(getApplicationContext(), "먼저 에디트 텍스트를 선택하세요.", Toast.LENGTH_SHORT).show();
                else {
                    switch(rdGroup.getCheckedRadioButtonId()) {
                        case R.id.rdAdd:
                            intent.putExtra("Calc", "+");
                            break;
                        case R.id.rdSub:
                            intent.putExtra("Calc", "-");
                            break;
                        case R.id.rdMul:
                            intent.putExtra("Calc", "*");
                            break;
                        case R.id.rdDiv:
                            intent.putExtra("Calc", "/");
                            break;
                        default:
                            break;
                    }
                    intent.putExtra("Num1", Integer.parseInt(edtNum1.getText().toString()));
                    intent.putExtra("Num2", Integer.parseInt(edtNum2.getText().toString()));
                    startActivityForResult(intent, 0);
                }
            }

        });

    }
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(resultCode == RESULT_OK) {
            int result = data.getIntExtra("Result", 0);
            Toast.makeText(getApplicationContext(), "계산결과 : " + result, Toast.LENGTH_SHORT).show();
        }
    }

}
