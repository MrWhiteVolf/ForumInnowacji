package com.nosoroce_czarne.foruminnowacji.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nosoroce_czarne.foruminnowacji.JakDojadeAPI;
import com.nosoroce_czarne.foruminnowacji.MapActivity;
import com.nosoroce_czarne.foruminnowacji.R;

public class MainActivity extends AppCompatActivity {
    private Button events;
    private Button event;
    private Button places;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        events = (Button) findViewById(R.id.events);
        event = (Button) findViewById(R.id.event);
        places = (Button) findViewById(R.id.places);
        final Intent intentEvents = new Intent(this, EventsActivity.class);
        final Intent intentEvent = new Intent(this, MapActivity.class);
        final Intent intentPlaces = new Intent(this, PlacesActivity.class);

        events.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentEvents);
                finish();            }
        });

        event.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(intentEvent);
                finish();
            }
        });

        places.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                JakDojadeAPI.getTrack(1, MainActivity.this);
                startActivity(intentPlaces);
                finish();
            }
        });
    }
}
