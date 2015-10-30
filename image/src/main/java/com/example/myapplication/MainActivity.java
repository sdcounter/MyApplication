package com.example.myapplication;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button btnExit, btnReset;
    RadioGroup rg1;
    RadioButton rbRoll, rbKit, rbJell;
    LinearLayout linear;
    Switch swt1;
    ImageView img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("안드로이드 사진 보기");

        btnExit = (Button) findViewById(R.id.btnExit);
        btnReset = (Button) findViewById(R.id.btnReset);
        rg1 = (RadioGroup) findViewById(R.id.rg1);
        rbRoll = (RadioButton) findViewById(R.id.rbRoll);
        rbJell = (RadioButton) findViewById(R.id.rbJell);
        rbKit = (RadioButton) findViewById(R.id.rbKit);
        linear = (LinearLayout) findViewById(R.id.linear);
        swt1 = (Switch) findViewById(R.id.swt1);
        img = (ImageView) findViewById(R.id.img);

        swt1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (swt1.isChecked() == true)
                    linear.setVisibility(View.VISIBLE);
                else
                    linear.setVisibility(View.INVISIBLE);
            }
        });
        btnExit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = getBaseContext().getPackageManager().getLaunchIntentForPackage(getBaseContext().getPackageName());
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });
        rg1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rbJell:
                        img.setImageResource(R.drawable.jell);
                        break;
                    case R.id.rbKit:
                        img.setImageResource(R.drawable.kit);
                        break;
                    case R.id.rbRoll:
                        img.setImageResource(R.drawable.roll);
                }
            }
        });
    }

}

