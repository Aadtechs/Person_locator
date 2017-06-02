package com.arunverma.www.person_locator;

import android.Manifest;
import android.app.IntentService;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.annotation.Nullable;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.ActivityChooserView;
import android.view.View;

/**
 * Created by Arun on 31-05-2017.
 */

public class MyLocation extends IntentService {

    private LocationManager locationManager;
    private LocationListener locationListener;


    public MyLocation() {
        super("MyLocation");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

        locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);
        locationListener = new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {
               double longitude= location.getLongitude();
               double latitude= location.getLatitude();
                MyLocation m = new MyLocation();
                m.location(longitude,latitude);
            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {

            }

            @Override
            public void onProviderEnabled(String provider) {

            }

            @Override
            public void onProviderDisabled(String provider) {
                Intent intent= new Intent(Settings.ACTION_LOCATION_SOURCE_SETTINGS);
                startActivity(intent);
            }
        };

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }else {
                locationManager.requestLocationUpdates("gps", 5000, 0, locationListener);
            }
        }

 }
    public void location(double x,double y){
        String Longitude = Double.toString(x);
        String Latitude = Double.toString(y);
        String type = "location";
        BackGroundWorker backGroundWorker = new BackGroundWorker(this);
        backGroundWorker.execute(type,Longitude,Latitude);

    }


}
