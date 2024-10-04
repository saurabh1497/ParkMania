package com.example.admin.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import static com.example.admin.signup.R.id.radioButton71;
import static com.example.admin.signup.R.id.radioVType;

public class Car1Activity extends AppCompatActivity {
    private RadioButton SelectZone;
    private RadioGroup VehicleType;
    private Button Proceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        addListener();
        }
    public void addListener() {
        VehicleType = (RadioGroup) findViewById(radioVType);

        //fourWheeler = (RadioButton) findViewById(R.id.radioButton2);

        Proceed = (Button) findViewById(R.id.button7);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = VehicleType.getCheckedRadioButtonId();
                SelectZone = (RadioButton) findViewById(selectedId);
                Toast.makeText(getApplicationContext(),
                        SelectZone.getText(), Toast.LENGTH_SHORT).show();
                if (SelectZone.getId() == radioButton71) {
                    OnProceedToFourWheelerSlots();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Select a zone",Toast.LENGTH_SHORT).show();
                }




                //OnProceedToTwoWheeler();
            }
        });
    }
    private void OnProceedToFourWheelerSlots(){
        Intent intent=new Intent(getApplicationContext(),FourWheelSlotsActivity.class);
        startActivity(intent);

    }}
