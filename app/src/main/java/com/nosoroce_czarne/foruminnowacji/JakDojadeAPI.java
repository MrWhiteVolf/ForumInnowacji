package com.nosoroce_czarne.foruminnowacji;


import android.app.Activity;
import android.location.Location;

import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JakDojadeAPI {

    public static String getTrack(Integer placeID, Activity activity){

        Location location = GPSTracker.getLocation(activity);

        //get place Location (longitude, latitude)
        //Location placeLocation =

        Date date = new Date();

        String res = "";
        String patternDate = "yy.MM.dd";
        String patternTime = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDate);
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(patternTime);
        String formattedDate = simpleDateFormat.format(date);
        String formattedTime = simpleTimeFormat.format(date);

        String urlString = "https://jakdojade.pl/tarnow/trasa/z--undefined--do--undefined?tc="+location.getLatitude()+":"+location.getLongitude()+"&fc="+50.013342/*placeLocation.getLatitude()*/+":"+20.990255/*placeLocation.getLongitude*/+"&ft=LOCATION_TYPE_COORDINATE&tt=LOCATION_TYPE_COORDINATE&d="+formattedDate+"&h="+formattedTime+"&aro=1&t=1&rc=3&ri=1&r=0";
        try {
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            res = conn.getResponseMessage();
        }catch (Exception e){
            System.out.println("JakDojadeAPI(getTrack): "+ e.getMessage());
        }

        return res;
    }

}
