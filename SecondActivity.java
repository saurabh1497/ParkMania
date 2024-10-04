package com.example.admin.signup;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.maps.MapsInitializer;
import com.google.firebase.auth.FirebaseAuth;

//import static com.example.admin.signup.R.id.button9;
import static com.example.admin.signup.R.id.intent_action;
import static com.example.admin.signup.R.id.textView;
import static com.example.admin.signup.R.id.textView6;
//import static com.example.admin.signup.R.id.textViewLog;

public class SecondActivity extends AppCompatActivity {
    private Button BookASlot;
    private Button NearBy;
    private Button Nearest;
   // private Button Login;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        BookASlot=(Button)findViewById(R.id.button3);
        //Login=(Button)findViewById(button9);
        NearBy=(Button)findViewById(R.id.button12);
        Nearest=(Button)findViewById(R.id.button40);
        firebaseAuth=FirebaseAuth.getInstance();

        Nearest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(),Maps2Activity.class));
            }
        });


        NearBy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(SecondActivity.this,MapsActivity.class));
            }
        });
        //Login.setOnClickListener(new View.OnClickListener() {
          //  @Override
            //public void onClick(View v) {
              //  firebaseAuth.signOut();
                //finish();
                //startActivity(new Intent(SecondActivity.this,MainActivity.class));
            //}
        //});
        BookASlot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GoToOtherPage();
            }
        });
    }

    private void GoToOtherPage(){
        Intent intent=new Intent(SecondActivity.this,ThirdActivity.class);
        startActivity(intent);
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
                Intent intent=new Intent(SecondActivity.this,MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent);
                break;

            }
           case R.id.profileMenu:
               startActivity(new Intent(SecondActivity.this,ViewProfileActivity.class));
               break;
        }
        return super.onOptionsItemSelected(item);
    }


}
