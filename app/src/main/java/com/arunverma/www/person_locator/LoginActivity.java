package com.arunverma.www.person_locator;

import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.app.NotificationManager;
import android.support.v7.app.NotificationCompat;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class LoginActivity extends ActionBarActivity{
    NotificationCompat.Builder notification;
    private static final int uniqueID = 45612;
EditText UsernameET , PasswordET;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //for background service which update longitude and latitude to database

        Intent intent1 = new Intent(this, MyLocation.class);
        startService(intent1);

        //for notification

        notification = new NotificationCompat.Builder(this);
        notification.setAutoCancel(true);

        UsernameET = (EditText)findViewById(R.id.editText1);
        PasswordET = (EditText)findViewById(R.id.editText2);

        notification.setSmallIcon(R.drawable.map);
        notification.setTicker("this is the Ticker");
        notification.setWhen(System.currentTimeMillis());
        notification.setContentTitle("Login In");
        notification.setContentText("Wait u r currently login in...");

        Intent intent = new Intent(this, LoginActivity.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        notification.setContentIntent(pendingIntent);

        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.notify(uniqueID, notification.build());


    }

    public void Login(View view){
    String username = UsernameET.getText().toString();
    String password = PasswordET.getText().toString();
     String type = "login";
        BackGroundWorker backGroundWorker = new BackGroundWorker(this);
        backGroundWorker.execute(type,username,password);



    }
    public void Register(View view){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);

    }

}
