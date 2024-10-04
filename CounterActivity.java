package com.example.admin.signup;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseException;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.text.SimpleDateFormat;
import java.util.Date;

import static android.R.attr.name;

public class CounterActivity extends AppCompatActivity {

    private String EVENT_DATE_TIME = "2019-10-21 10:30:00";
    private String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";
    private LinearLayout linear_layout_1, linear_layout_2;
    private TextView tv_days, tv_hour, tv_minute, tv_second;
    private Handler handler = new Handler();
    private Runnable runnable;
    private DatabaseReference mDatabase;
    private FirebaseAuth firebaseAuth;
    private FirebaseDatabase firebaseDatabase;
    public String etime,stime;
    public String str;
    public int i,fi_min,cal_min;
    public int hours,mins,seconds;
    public long min;
    public TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);
        tv=(TextView)findViewById(R.id.tv12);

        firebaseAuth=FirebaseAuth.getInstance();
        firebaseDatabase= FirebaseDatabase.getInstance();
        DatabaseReference databaseReference=firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());

       databaseReference.child("Time Duration").addValueEventListener(new ValueEventListener() {
           @Override
           public void onDataChange(DataSnapshot dataSnapshot) {
               ParkingData5 parkingData5 = null;
               try {
                   //for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                       // parkingData5 = snapshot.getValue(ParkingData5.class);
                   parkingData5 = dataSnapshot.getValue(ParkingData5.class);
               //}

               }catch (DatabaseException ignored){

               }
try{
    hours = parkingData5.getHours();
    mins = parkingData5.getMins();
    seconds = parkingData5.getSeconds();}
catch(NullPointerException ignored){}
    System.out.println("Hours in call:"+hours);
    System.out.println("Mins in call:"+mins);
    System.out.println("Seconds in call:"+seconds);

               cal_min = ((hours * 60) + mins);
               System.out.println("Cal min: "+cal_min);
               //fi_min=Integer.parseInt(cal_min);
               min=cal_min*60*1000;
               //min=fi_min*60*1000;
               counter(min);
           }

           @Override
           public void onCancelled(DatabaseError databaseError) {

           }
       });

        System.out.println("Hours in onc:"+hours);
        System.out.println("Mins in onc:"+mins);
        System.out.println("Seconds in onc:"+seconds);

    }

    private void counter(long min) {
        CountDownTimer timer = new CountDownTimer(min, 1000) {
            public void onTick(long millisUntilFinished) {
                int seconds = (int) (millisUntilFinished / 1000) % 60;
                int minutes = (int) ((millisUntilFinished / (1000 * 60)) % 60);
                int hours = (int) ((millisUntilFinished / (1000 * 60 * 60)) % 24);
                tv.setText(String.format("%d:%d:%d", hours, minutes, seconds));
            }
            public void onFinish() {
                Toast.makeText(getApplicationContext(), "Your time has been completed",
                        Toast.LENGTH_LONG).show();
            }
        };
        timer.start();
    }


}