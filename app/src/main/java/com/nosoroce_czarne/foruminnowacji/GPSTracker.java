package com.nosoroce_czarne.foruminnowacji;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.location.Location;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.Task;

public class GPSTracker{

    private static FusedLocationProviderClient fusedLocationProviderClient;

    @SuppressLint("MissingPermission")
    public static Location getLocation(Activity activity){
        Task<Location> location;
        fusedLocationProviderClient = LocationServices.getFusedLocationProviderClient(activity);
        location = fusedLocationProviderClient.getLastLocation();
        return location.getResult();
    }

}
