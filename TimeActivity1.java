package com.example.admin.signup;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.Calendar;

public class TimeActivity1 extends AppCompatActivity {
    EditText SelectDate;
    EditText chooseStartTime;
    EditText chooseEndTime;
    Button Proceed;
    TimePickerDialog timePickerDialog;
    DatePickerDialog datePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    int currentSeconds;
    int year;
    int month;
    int dayOfMonth;
    String amPm;
    String stime,etime,date;
    private FirebaseAuth firebaseAuth;
    private DatabaseReference databaseReference;
    //String vehicleType, zone, slot;
    String name, email, mobile, passwd;
  //  String StartTime,EndTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time1);
        firebaseAuth = FirebaseAuth.getInstance();

        chooseStartTime = (EditText)findViewById(R.id.etChooseStartTime);
        stime=chooseStartTime.getText().toString();
        chooseEndTime=(EditText)findViewById(R.id.etChooseEndTime);
        etime=chooseEndTime.getText().toString();
        SelectDate=(EditText)findViewById(R.id.editText8);
        date=SelectDate.getText().toString();
        Proceed=(Button)findViewById(R.id.button29);
        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                Intent intent=new Intent(getApplicationContext(),PricingActivity.class);
                startActivity(intent);
                    AddParkingData();
            }
            }
        });
        chooseStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);
                //currentSeconds=calendar.get(Calendar.SECOND);

                timePickerDialog = new TimePickerDialog(TimeActivity1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseStartTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute,false);

                timePickerDialog.show();

            }
        });

        chooseEndTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TimeActivity1.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12 && minutes>=0) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        chooseEndTime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });
        SelectDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                year = calendar.get(Calendar.YEAR);
                month = calendar.get(Calendar.MONTH);
                dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH);
                datePickerDialog = new DatePickerDialog(TimeActivity1.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                                SelectDate.setText(day + "/" + (month + 1) + "/" + year);
                            }
                        }, year, month, dayOfMonth);
                datePickerDialog.getDatePicker().setMinDate(System.currentTimeMillis());
                datePickerDialog.show();
            }
        });
    }

    private Boolean validate(){
        Boolean result=false;
        stime=chooseStartTime.getText().toString();
        etime=chooseEndTime.getText().toString();
        date=SelectDate.getText().toString();
        if (date.isEmpty() || stime.isEmpty() || etime.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter date and time duration", Toast.LENGTH_SHORT).show();
        }
        else if(stime.equals(etime)){
            Toast.makeText(getApplicationContext(), "Enter a valid time duration", Toast.LENGTH_SHORT).show(); //else if (stime.length() > 2) {
        }
            //Toast.makeText(getApplicationContext(), "Please enter correct start time", Toast.LENGTH_SHORT).show();


        //} else if (dtime.length() > 2) {
          //  Toast.makeText(getApplicationContext(), "Please enter correct end time", Toast.LENGTH_SHORT).show();
        //
        else {
            result=true;
            //startActivity(new Intent(getApplicationContext(), PaymentOptionsActivity.class));
        }
        return result;

    }
    public void AddParkingData() {
        //rg.AddData();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        DatabaseReference reference6 = firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        ParkingData3 pd3 = new ParkingData3(name, email, mobile, passwd, stime,etime,date);
        reference6.child("Date & Time Slot").setValue(pd3);
        //reference6.child("Etime").setValue(pd3);
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
                Intent intent=new Intent(TimeActivity1.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                //startActivity(new Intent(TimeActivity1.this,MainActivity.class));
                //onBackPressed();
                break;
            }
            case R.id.profileMenu:
                startActivity(new Intent(TimeActivity1.this,ViewProfileActivity.class));
                break;
        }
        return super.onOptionsItemSelected(item);
    }


}


