package com.example.admin.signup;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegistrationActivity extends AppCompatActivity {
    private EditText Name;
    private EditText Email;
    private EditText MobileNo;
    private EditText Password;
    private EditText ConfirmPassword;
    private Button Signup;
    private TextView Loggedin;
    private FirebaseAuth firebaseAuth;
    private ProgressDialog progressDialog;
    //private FirebaseDatabase firebaseDatabase;
    String name,email,mobile,passwd,cnfpasswd;
    String enPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        assign();
        firebaseAuth=FirebaseAuth.getInstance();
        progressDialog = new ProgressDialog(RegistrationActivity.this);

        Signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(validate()){
                    progressDialog.setMessage("Please wait untill your account is being created");
                    progressDialog.show();

                    String user_email=Email.getText().toString().trim();
                    String user_password=Password.getText().toString().trim();
                    firebaseAuth.createUserWithEmailAndPassword(user_email,user_password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if(task.isSuccessful()){
                                progressDialog.dismiss();
                                AddData();
                                firebaseAuth.signOut();

                                Toast.makeText(getApplicationContext(),"Registration Successfull",Toast.LENGTH_SHORT).show();
                                finish();
                                progressDialog.dismiss();
                                startActivity(new Intent(RegistrationActivity.this,MainActivity.class));

                            } else{
                                Toast.makeText(getApplicationContext(),"Registration Unsuccessfull",Toast.LENGTH_SHORT).show();
                            }
                        }
                    });

                }

            }
        });
        Loggedin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ReturnToLogin();

            }
        });
    }
    private void assign(){
        Name=(EditText) findViewById(R.id.editText2);
        Email=(EditText) findViewById(R.id.editText4);
        MobileNo=(EditText)findViewById(R.id.editText9);
        Password=(EditText) findViewById(R.id.editText5);
        ConfirmPassword=(EditText)findViewById(R.id.editText10);
        Signup=(Button) findViewById(R.id.button2);
        Loggedin=(TextView) findViewById(R.id.textView6);

    }
    private Boolean validate(){
        Boolean result=false;
        name=Name.getText().toString();
        passwd=Password.getText().toString();
        cnfpasswd=ConfirmPassword.getText().toString();
        email=Email.getText().toString();
        mobile=MobileNo.getText().toString();

        if(name.isEmpty() || passwd.isEmpty() || email.isEmpty() || mobile.isEmpty() || cnfpasswd.isEmpty()){
            Toast.makeText(getApplicationContext(),"Please enter all the details",Toast.LENGTH_SHORT).show();
        }
        else if(!Patterns.EMAIL_ADDRESS.matcher(email).matches()){
            Toast.makeText(getApplicationContext(),"Please enter valid email id.",Toast.LENGTH_SHORT).show();
        }
        else if(mobile.length()<10 || mobile.length()>10){
            Toast.makeText(getApplicationContext(),"Please enter valid mobile no.",Toast.LENGTH_SHORT).show();
        }
        else if(passwd.length()<6 || passwd.length()>10){
            Toast.makeText(getApplicationContext(),"Please enter valid password.",Toast.LENGTH_SHORT).show();
        }
        else if(!cnfpasswd.equals(passwd)){
            Toast.makeText(getApplicationContext(),"Both passwords should match",Toast.LENGTH_SHORT).show();
        }
        else
        {
            result=true;
        }
        return result;

    }
    private void ReturnToLogin(){
        Intent intent=new Intent(getApplicationContext(),MainActivity.class);
        startActivity(intent);
    }
    public void AddData(){
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
        DatabaseReference reference=firebaseDatabase.getReference(firebaseAuth.getCurrentUser().getUid());
        UserProfile userProfile=new UserProfile(mobile,name,email,passwd);
        reference.setValue(userProfile);
    }


}