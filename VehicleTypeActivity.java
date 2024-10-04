package com.example.admin.signup;

import android.content.Intent;
import android.support.annotation.CheckResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static android.R.attr.id;
import static com.example.admin.signup.R.id.radioButton;
import static com.example.admin.signup.R.id.radioButton2;
import static com.example.admin.signup.R.id.radioVType;

public class VehicleTypeActivity extends AppCompatActivity {
    private Button TwoWheeler;
    private Button FourWheeler;
    private Button Proceed;
    String twowheeler,fourwheeler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_third);
        TwoWheeler = (Button) findViewById(R.id.button10);
        FourWheeler = (Button) findViewById(R.id.button11);
        Proceed = (Button) findViewById(R.id.button6);
        TwoWheeler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SendToDatabase();
                FourWheeler.setEnabled(false);

            }
        });
        //addListener();

    }
    private void SendToDatabase(){
        twowheeler=TwoWheeler.getText().toString();
        fourwheeler=FourWheeler.getText().toString();
        if(TwoWheeler.isPressed()){
            Toast.makeText(VehicleTypeActivity.this,"2-Wheeler Selected",Toast.LENGTH_SHORT).show();
        }else if(FourWheeler.isPressed()){
            Toast.makeText(VehicleTypeActivity.this,"4-Wheeler Selected",Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(VehicleTypeActivity.this,"Error",Toast.LENGTH_SHORT).show();
        }
    }
}

