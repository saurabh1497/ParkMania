package com.example.admin.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FourWheelSlotsActivity extends AppCompatActivity {
    private Button C01;
    private Button C02;
    private Button C03;
    private Button C04;
    private Button C05;
    private Button C06;
    private Button C07;
    private Button C08;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheel_slots);
        C01=(Button)findViewById(R.id.btn10);
        C02=(Button)findViewById(R.id.btn11);
        C03=(Button)findViewById(R.id.btn12);
        C04=(Button)findViewById(R.id.btn13);
        C05=(Button)findViewById(R.id.btn14);
        C06=(Button)findViewById(R.id.btn15);
        C07=(Button)findViewById(R.id.btn16);
        C08=(Button)findViewById(R.id.button23);
        C01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToDateTime();
            }
        });

        C07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToDateTime();
            }
        });

        C08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C08.setEnabled(false);
            }
        });

        C02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToDateTime();
            }
        });
        C03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToDateTime();
            }
        });
        C04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C04.setEnabled(false);
            }
        });
        C05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C05.setEnabled(false);
            }
        });

        C06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ProceedToDateTime();
            }
        });

    }
    private void ProceedToDateTime(){
        Intent intent=new Intent(getApplicationContext(),DateTimeActivity.class);
        startActivity(intent);
    }
}
