package com.arunverma.www.person_locator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class Locator extends AppCompatActivity {

    EditText phoneNo;
    String PhoneNo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locator);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        phoneNo = (EditText) findViewById(R.id.UserPhone);
    }

    public  void Locate(View view){

        String type = "locator";
        PhoneNo = phoneNo.getText().toString();

        BackGroundWorker backGroundWorker = new BackGroundWorker(this);
        String y =backGroundWorker.execute(type,PhoneNo,"",123);
        Intent i = new Intent(this , MapsActivity.class);
        i.putExtra("location", y);
        startActivity(i);
    }

    }




/* */