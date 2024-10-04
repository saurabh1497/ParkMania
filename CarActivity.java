package com.example.admin.signup;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class CarActivity extends AppCompatActivity {
    private RadioButton Zone;
    private RadioGroup VehicleType;
    private Button Proceed;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);
        //addListener();
    //}
    /*public void addListener() {
        VehicleType = (RadioGroup) findViewById(radioVType);

        //fourWheeler = (RadioButton) findViewById(R.id.radioButton2);

        Proceed = (Button) findViewById(R.id.button7);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = VehicleType.getCheckedRadioButtonId();
                Zone = (RadioButton) findViewById(selectedId);
                Toast.makeText(getApplicationContext(),
                        Zone.getText(), Toast.LENGTH_SHORT).show();
                if (Zone.getId() == radioButton7) {
                    OnProceedToTwoWheelerSlots();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Select a zone",Toast.LENGTH_SHORT).show();
                }




                //OnProceedToTwoWheeler();
            }
        });
    }
    private void OnProceedToTwoWheelerSlots(){
        Intent intent=new Intent(getApplicationContext(),FourWheelSlotsActivity.class);
        startActivity(intent);
*/
    }}
