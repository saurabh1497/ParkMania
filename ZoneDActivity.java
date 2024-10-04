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

public class ZoneDActivity extends AppCompatActivity {
    private Button D01;
    private Button D02;
    private Button D03;
    private Button D04;
    private Button D05;
    private Button D06;
    private Button D07;
    private Button D08;

    String vehicleType, zone, slot;
    String name, email, mobile, passwd;

    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_d);
        firebaseAuth=FirebaseAuth.getInstance();
        D01=(Button)findViewById(R.id.button9);
        D02=(Button)findViewById(R.id.button30);
        D03=(Button)findViewById(R.id.button31);
        D04=(Button)findViewById(R.id.button32);
        D05=(Button)findViewById(R.id.button33);
        D06=(Button)findViewById(R.id.button34);
        D07=(Button)findViewById(R.id.button35);
        D08=(Button)findViewById(R.id.button36);

        D01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=D01.getText().toString();
                ProceedToTime();
                AddParkingData();

            }
        });

        D02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=D02.getText().toString();
                ProceedToTime();
                AddParkingData();

            }
        });

        D03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=D03.getText().toString();
                ProceedToTime();
                AddParkingData();

            }
        });

        D04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D04.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        D05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=D05.getText().toString();
                ProceedToTime();
                AddParkingData();

            }
        });

        D06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D06.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        D07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D07.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        D08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                D08.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void ProceedToTime(){
        Intent intent=new Intent(getApplicationContext(),TimeActivity1.class);
        startActivity(intent);
    }
    /* private void addData1(){
         FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
         DatabaseReference reference=firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
         AddSlot addSlot=new AddSlot();
         reference.setValue(userProfile);
     */
    public void AddParkingData() {
        //rg.AddData();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference5 = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        ParkingData2 pd2 = new ParkingData2(name, email, mobile, passwd, slot);
        reference5.child("slot").setValue(pd2);
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
                Intent intent=new Intent(ZoneDActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(ZoneDActivity.this,ViewProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }






}
