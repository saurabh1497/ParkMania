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

public class ZoneBActivity extends AppCompatActivity {
    private Button B01;
    private Button B02;
    private Button B03;
    private Button B04;
    private Button B05;
    private Button B06;
    private Button B07;
    private Button B08;
    String vehicleType, zone, slot;
    String name, email, mobile, passwd;

    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;

    //private DatabaseReference mDatabase;
    //private FirebaseAuth firebaseAuth;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zone_b);
        firebaseAuth=FirebaseAuth.getInstance();
        B01=(Button)findViewById(R.id.button13);
        B02=(Button)findViewById(R.id.button14);
        B03=(Button)findViewById(R.id.button22);
        B04=(Button)findViewById(R.id.button24);
        B05=(Button)findViewById(R.id.button25);
        B06=(Button)findViewById(R.id.button26);
        B07=(Button)findViewById(R.id.button27);
        B08=(Button)findViewById(R.id.button28);
       // mDatabase= FirebaseDatabase.getInstance().getReference();
        B01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=B01.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        B02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=B02.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        B05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=B05.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });

        B07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=B07.getText().toString();
                ProceedToTime();
                AddParkingData();

            }
        });


        B08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B08.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

       // B02.setOnClickListener(new View.OnClickListener() {
           // @Override
           // public void onClick(View v) {
                //mDatabase.child(FirebaseAuth.getInstance().getCurrentUser().getUid()).setValue("A02");
             //   ProceedToTime();
          //  }
      //  });
        B03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B03.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });
        B04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                slot=B04.getText().toString();
                ProceedToTime();
                AddParkingData();
            }
        });
        B06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                B06.setEnabled(false);
                Toast.makeText(getApplicationContext(),"Slot is occupied",Toast.LENGTH_SHORT).show();
            }
        });

        //B07.setOnClickListener(new View.OnClickListener() {
          //  @Override
           // public void onClick(View v) {
            //    ProceedToTime();
           // }
       // });

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
                Intent intent=new Intent(ZoneBActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(ZoneBActivity.this,ViewProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }



}

