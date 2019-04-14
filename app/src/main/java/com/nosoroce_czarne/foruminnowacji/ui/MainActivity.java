package com.nosoroce_czarne.foruminnowacji.ui;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nosoroce_czarne.foruminnowacji.JakDojadeAPI;
import com.nosoroce_czarne.foruminnowacji.MapActivity;
import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.model.Place;

public class MainActivity extends AppCompatActivity {
    private Button events;
    private Button event;
    private Button places;
    private Button single;
    private String wyjebany = "Teatr im. Ludwika Solskiego w Tarnowie – samorządowa instytucja kultury m. Tarnowa, teatr dramatyczny działający od 1945 w budynku byłego Polskiego Towarzystwa Gimnastycznego „Sokół”";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events = (Button) findViewById(R.id.events);
        event = (Button) findViewById(R.id.event);
        places = (Button) findViewById(R.id.places);
        single = (Button) findViewById(R.id.single);


        final Intent intentEvents = new Intent(this, EventsActivity.class);
        final Intent intentEvent = new Intent(this, MapActivity.class);
        final Intent intentPlaces = new Intent(this, PlacesActivity.class);
        final Intent intentSingle = new Intent(this, SingleActivity.class);
        final Intent intentTrack = new Intent(this, TrackActivity.class);

        events.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentEvents);
            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentEvent.putExtra("mainMode","Main");
                startActivity(intentEvent);
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentTrack);
            }
        });

        single.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                intentSingle.putExtra("Place", new Place("Teatr im. Ludwika Solskiego w Tarnowie", wyjebany, "teatr.jpg", "ul. Mickiewicza 4", 50.0158, 20.9875));
                startActivity(intentSingle);
            }
        });
    }

}
