package com.example.admin.signup;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class TwoWheelSlotsActivity extends AppCompatActivity {
    private Button A01;
    private Button A02;
    private Button A03;
    private Button A04;
    private Button A05;
    private Button A06;
    private Button A07;
    private Button A08;
    String vehicleType, zone, slot;
    String name, email, mobile, passwd;
    String s1,s2,s3;

    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_two_wheel_slots);
        firebaseAuth=FirebaseAuth.getInstance();
        A01=(Button)findViewById(R.id.btn1);
        A02=(Button)findViewById(R.id.button15);
        A03=(Button)findViewById(R.id.button16);
        A04=(Button)findViewById(R.id.button17);
        A05=(Button)findViewById(R.id.button18);
        A06=(Button)findViewById(R.id.button19);
        A07=(Button)findViewById(R.id.button20);
        A08=(Button)findViewById(R.id.button21);
        //mDatabase= FirebaseDatabase.getInstance().getReference();


        A01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase=firebaseDatabase.getInstance().getReference("Parking Slots 2");
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                         s1=dataSnapshot.child("Slots").child("A01").getValue(String.class);
                        System.out.println("S1 value is :"+s1);
                        if(s1.equals("Y")){
                            slot=A01.getText().toString();
                            ProceedToTime();
                            AddParkingData();}
                        else{
                            A01.setEnabled(false);
                            Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();}
                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {

                    }
                });
            }
        });

        A07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=A07.getText().toString();
                ProceedToTime();
                AddParkingData();
                //A07.setEnabled(false);
                //Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        A08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=A08.getText().toString();
                ProceedToTime();
                AddParkingData();
                //A08.setEnabled(false);
                //Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        A02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase=firebaseDatabase.getInstance().getReference("Parking Slots 2");
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        s2=dataSnapshot.child("Slots").child("A02").getValue(String.class);
                        if(s2.equals("Y")){
                            slot=A02.getText().toString();
                            ProceedToTime();
                            AddParkingData();
                            mDatabase.child("Slots").child("A02").setValue("N");

                        }
                        else{
                            A02.setEnabled(false);
                            Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        A03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mDatabase=firebaseDatabase.getInstance().getReference("Parking Slots 2");
                mDatabase.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        s3=dataSnapshot.child("Slots").child("A03").getValue(String.class);
                        if(s3.equals("Y")){
                            slot=A03.getText().toString();
                            ProceedToTime();
                            AddParkingData();
                            mDatabase.child("Slots").child("A03").setValue("N");

                        }
                        else{
                            A03.setEnabled(false);
                            Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();}
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });

            }
        });
        A04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=A04.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        A05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=A05.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });

        A06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=A06.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
//query

        //mDatabase=firebaseDatabase.getInstance().getReference("Parking Slots");

      /*  mDatabase.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                checkStatus(dataSnapshot);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });*/
    }
    private void ProceedToTime(){
        Intent intent=new Intent(getApplicationContext(),TimeActivity1.class);
        startActivity(intent);
    }
    //My code starts
    private void checkStatus(DataSnapshot dataSnapshot) {

        //for(DataSnapshot ds:dataSnapshot.getChildren()){
            //ParkingData2 pd2=new ParkingData2();

            String s1=dataSnapshot.child("Slot No1").getValue(String.class);
            String s2=dataSnapshot.child("Slot No2").getValue(String.class);
            String s3=dataSnapshot.child("Slot No3").getValue(String.class);
            String s4=dataSnapshot.child("Slot No4").getValue(String.class);
            System.out.print("Slot:"+s1);
            if(s1.equals(slot)){
                A01.setEnabled(false);
                Toast.makeText(this,"Slot 1 Already booked",Toast.LENGTH_LONG).show();
            }
            if(s2.equals(slot)){
                A02.setEnabled(false);
                Toast.makeText(this,"Slot 2 Already booked",Toast.LENGTH_LONG).show();
            }
            if(s3.equals(slot)){
                A03.setEnabled(false);
                Toast.makeText(this,"Slot 3 Already booked",Toast.LENGTH_LONG).show();
            }
            if(s4.equals(slot)){
                A04.setEnabled(false);
                Toast.makeText(this,"Slot 4 Already booked",Toast.LENGTH_LONG).show();
            }

    }




    //My code ends



   /* private void addData1(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        AddSlot addSlot=new AddSlot();
        reference.setValue(userProfile);
    }*/
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
                Intent intent=new Intent(TwoWheelSlotsActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(TwoWheelSlotsActivity.this,ViewProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }

}


