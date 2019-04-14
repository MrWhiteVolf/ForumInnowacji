package com.nosoroce_czarne.foruminnowacji;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;
import android.util.Log;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;

public class GPSTracker{

    private static FusedLocationProviderClient fusedLocationProviderClient;

    @SuppressLint("MissingPermission")
    public static Location getLocation(Activity activity){
        Task<Location> locationTask;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
        locationTask = fusedLocationProviderClient.getLastLocation();

        locationTask.addOnSuccessListener(activity,new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if(location!=null) {
                    //Write your implemenation here
                    Log.d("Log",location.getLatitude()+" "+location.getLongitude());      }
            }
        });

        //return locationTask.getResult();

        Location l = new Location("");
        l.setLatitude(50.0155713);
        l.setLongitude(20.9538459);
        return l;
    }

}
