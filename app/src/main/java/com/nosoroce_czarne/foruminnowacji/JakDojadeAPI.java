package com.nosoroce_czarne.foruminnowacji;

import android.app.Activity;
import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.util.Log;


import java.net.HttpURLConnection;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JakDojadeAPI {

    public Intent getTrack(Integer placeID, Activity activity){

        Location location = GPSTracker.getLocation(activity);

        //get place Location (longitude, latitude)
        //Location placeLocation =

        Date date = new Date();

        String res = "";
        String patternDate = "dd.MM.yy";
        String patternTime = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDate);
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(patternTime);
        String formattedDate = simpleDateFormat.format(date);
        String formattedTime = simpleTimeFormat.format(date);

        URL url = null;
        HttpURLConnection conn = null;
        String urlString = "https://jakdojade.pl/tarnow/trasa/z--undefined--do--undefined?tc="+location.getLatitude()+":"+location.getLongitude()+"&fc="+50.0133421/*placeLocation.getLatitude()*/+":"+20.9902551/*placeLocation.getLongitude*/+"&ft=LOCATION_TYPE_COORDINATE&tt=LOCATION_TYPE_COORDINATE&d="+formattedDate+"&h="+formattedTime+"&aro=1&t=1&rc=3&ri=1&r=0";
        Log.d("URL", urlString);

        Intent httpIntent = new Intent(Intent.ACTION_VIEW);
        httpIntent.setData(Uri.parse(urlString));

        return httpIntent;
    }



}
