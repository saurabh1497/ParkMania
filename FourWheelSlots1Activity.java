package com.example.admin.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FourWheelSlots1Activity extends AppCompatActivity {
    private Button C01;
    private Button C02;
    private Button C03;
    private Button C04;
    private Button C05;
    private Button C06;
    private Button C07;
    private Button C08;
    String vehicleType, zone, slot;
    String name, email, mobile, passwd;

    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_four_wheel_slots1);
        firebaseAuth=FirebaseAuth.getInstance();
        C01=(Button)findViewById(R.id.btn10);
        C02=(Button)findViewById(R.id.btn11);
        C03=(Button)findViewById(R.id.btn12);
        C04=(Button)findViewById(R.id.btn13);
        C05=(Button)findViewById(R.id.btn14);
        C06=(Button)findViewById(R.id.btn15);
        C07=(Button)findViewById(R.id.btn16);
        C08=(Button)findViewById(R.id.button88);

        C01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=C01.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        C02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=C02.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        C03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=C03.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        C04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C04.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });
        C05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C05.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });
        C06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=C06.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        C07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=C07.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        C08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                C08.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });
    }
    //public void ProceedToDateTime(){
      //  Intent intent=new Intent(getApplicationContext(),DateTimeActivity.class);
        //startActivity(intent);
   // }
    public void ProceedToTime(){
        Intent intent=new Intent(getApplicationContext(),TimeActivity1.class);
        startActivity(intent);
    }
    public void AddParkingData() {
        //rg.AddData();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference4 = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        ParkingData2 pd2 = new ParkingData2(name, email, mobile, passwd, slot);
        reference4.child("slot").setValue(pd2);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu1,menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.logoutMenu:{
                firebaseAuth.signOut();
                finish();
                Intent intent=new Intent(FourWheelSlots1Activity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(FourWheelSlots1Activity.this,ViewProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}

