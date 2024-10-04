package com.example.admin.signup;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.sql.Time;
import java.util.Calendar;

public class TimeActivity extends AppCompatActivity {

   // EditText chooseTime;
    TimePickerDialog timePickerDialog;
    Calendar calendar;
    int currentHour;
    int currentMinute;
    String amPm;


    private EditText Stime;
    private EditText Dtime;
    private Button Proceed;
    String stime, dtime;
    FirebaseAuth firebaseAuth;
    FirebaseDatabase firebaseDatabase;
    DatabaseReference databaseReference;

    // private TextView AmPm1;
    //private TextView AmPm2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time);
        firebaseAuth= FirebaseAuth.getInstance();
        Stime = (EditText) findViewById(R.id.editText6);
       // Stime = stime.getText().toString();
        Dtime = (EditText) findViewById(R.id.editText7);
        //Dtime = dtime.getText().toString();
        Proceed = (Button) findViewById(R.id.button8);
        Stime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calendar = Calendar.getInstance();
                currentHour = calendar.get(Calendar.HOUR_OF_DAY);
                currentMinute = calendar.get(Calendar.MINUTE);

                timePickerDialog = new TimePickerDialog(TimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {
                        if (hourOfDay >= 12) {
                            amPm = "PM";
                        } else {
                            amPm = "AM";
                        }
                        Stime.setText(String.format("%02d:%02d", hourOfDay, minutes) + amPm);
                    }
                }, currentHour, currentMinute, false);

                timePickerDialog.show();
            }
        });




        Proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //if(validate()){
                    Intent intent=new Intent(getApplicationContext(),PaymentOptionsActivity.class);
                    startActivity(intent);
                }
            });
        }
    }


   /* private Boolean validate(){
        Boolean result=false;
        stime=Stime.getText().toString();
        dtime=Dtime.getText().toString();
        if (stime.isEmpty() || dtime.isEmpty()) {
            Toast.makeText(getApplicationContext(), "Please enter time duration", Toast.LENGTH_SHORT).show();
        } else if (stime.length() > 2) {
            Toast.makeText(getApplicationContext(), "Please enter correct start time", Toast.LENGTH_SHORT).show();


        } else if (dtime.length() > 2) {
            Toast.makeText(getApplicationContext(), "Please enter correct end time", Toast.LENGTH_SHORT).show();
        } else {
            result=true;
            //startActivity(new Intent(getApplicationContext(), PaymentOptionsActivity.class));
        }
        return result;

    }
  //  private void OnClick(){

        //TimePickerDialog timePickerDialog = new TimePickerDialog(TimeActivity.this, new TimePickerDialog.OnTimeSetListener() {
            @Override
          //  public void onTimeSet(TimePicker timePicker, int hourOfDay, int minutes) {

          //  }
       // }, 0, 0, false);
      //  timePickerDialog.show();
      //  chooseTime.setText(hourOfDay + ":" + minutes);
  //  }


}
       /* dtime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dtime.length()>2){
                    Toast.makeText(getApplicationContext(),"Invalid Time",Toast.LENGTH_SHORT).show();
                }else{
                    startActivity(new Intent(getApplicationContext(), PaymentOptionsActivity.class));

                }
            }
        });


    }
}*/