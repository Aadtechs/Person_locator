package com.arunverma.www.person_locator;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Register extends AppCompatActivity {

    Context context;

    EditText name,age,Username,password,password2,Phone_no;
    String Name,Age,username,Password,Password2,PhoneNo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name =(EditText) findViewById(R.id.Name);
        age =(EditText) findViewById(R.id.Age);
        Username =(EditText) findViewById(R.id.UserName);
        password =(EditText) findViewById(R.id.Password);
        password2 =(EditText) findViewById(R.id.password1);
        Phone_no =(EditText) findViewById(R.id.PhoneNo);

    }
    public void Register(View view){

        Name = name.getText().toString();
        Age = age.getText().toString();
        username = Username.getText().toString();
        Password = password.getText().toString();
        Password2 = password2.getText().toString();
        PhoneNo = Phone_no.getText().toString();
        if(Password.equals(Password2)){
            String type = "register";
            BackGroundWorker backGroundWorker = new BackGroundWorker(this);
            backGroundWorker.execute(type,Name,Age,username,Password,PhoneNo);
        }else{
            Toast.makeText(context,"Password Does't Match try again",Toast.LENGTH_LONG).show();
            password.setText("");
            password2.setText("");
        }


    }
}
