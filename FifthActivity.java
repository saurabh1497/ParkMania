package com.example.admin.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static com.example.admin.signup.R.id.radioButton;
import static com.example.admin.signup.R.id.radioButton3;
import static com.example.admin.signup.R.id.radioButton4;
import static com.example.admin.signup.R.id.radioButton5;
import static com.example.admin.signup.R.id.radioVType;

public class FifthActivity extends AppCompatActivity {
    private RadioButton Zone;
    private RadioGroup VehicleType;
    private Button Proceed;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    String vehicleType,zone,slot;
    String name,email,mobile,passwd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fifth);
        firebaseAuth=FirebaseAuth.getInstance();
        addListener();
    }
    public void addListener() {
        VehicleType = (RadioGroup) findViewById(radioVType);

        //fourWheeler = (RadioButton) findViewById(R.id.radioButton2);

        Proceed = (Button) findViewById(R.id.button4);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = VehicleType.getCheckedRadioButtonId();
                Zone = (RadioButton) findViewById(selectedId);
                zone=Zone.getText().toString();
                Toast.makeText(getApplicationContext(),
                        Zone.getText(), Toast.LENGTH_SHORT).show();
                if (Zone.getId() == radioButton5) {
                    OnProceedToFourWheelerSlots();
                    AddParkingData();
                }
                else{
                    Toast.makeText(getApplicationContext(),"Select a zone",Toast.LENGTH_SHORT).show();
                }




                //OnProceedToTwoWheeler();
            }
        });
    }
    private void OnProceedToFourWheelerSlots(){
        Intent intent=new Intent(getApplicationContext(),TwoWheelSlotsActivity.class);
        startActivity(intent);

    }
    public void AddParkingData() {
        //rg.AddData();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference3 = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        ParkingData1 pd1 = new ParkingData1(name, email, mobile, passwd, zone);
        reference3.child("zone").setValue(pd1);
    }



}
