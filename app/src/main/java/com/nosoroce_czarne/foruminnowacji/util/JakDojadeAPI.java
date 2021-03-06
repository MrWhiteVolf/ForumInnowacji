package com.nosoroce_czarne.foruminnowacji.util;

import android.content.Intent;
import android.location.Location;
import android.net.Uri;
import android.util.Log;


import com.nosoroce_czarne.foruminnowacji.mockDB.PlaceDB;
import com.nosoroce_czarne.foruminnowacji.model.Place;

import java.text.SimpleDateFormat;
import java.util.Date;

public class JakDojadeAPI {

    public Intent getTrack(String placeID, Location location){

        Date date = new Date();

        String res = "";
        String patternDate = "dd.MM.yy";
        String patternTime = "HH:mm";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patternDate);
        SimpleDateFormat simpleTimeFormat = new SimpleDateFormat(patternTime);
        String formattedDate = simpleDateFormat.format(date);
        String formattedTime = simpleTimeFormat.format(date);


        new PlaceDB();
        Place placeLocation = PlaceDB.getPlaceByID(placeID);
        String urlString = "https://jakdojade.pl/tarnow/trasa/z--undefined--do--undefined?tc="+location.getLatitude()+":"+location.getLongitude()+"&fc="+placeLocation.getLatitude()+":"+placeLocation.getLongitude()+"&ft=LOCATION_TYPE_COORDINATE&tt=LOCATION_TYPE_COORDINATE&d="+formattedDate+"&h="+formattedTime+"&aro=1&t=1&rc=3&ri=1&r=0";
        Log.d("URL", urlString);

        Intent httpIntent = new Intent(Intent.ACTION_VIEW);
        httpIntent.setData(Uri.parse(urlString));

        return httpIntent;
    }



}
