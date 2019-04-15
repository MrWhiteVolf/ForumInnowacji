package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.mockDB.EventDB;
import com.nosoroce_czarne.foruminnowacji.model.Event;
import com.nosoroce_czarne.foruminnowacji.model.Place;
import com.nosoroce_czarne.foruminnowacji.util.CustomListAdapter;

import java.util.ArrayList;
import java.util.List;

public class  SingleActivity extends AppCompatActivity {
    private ImageView localizeImageView;
    private ImageView ivLogo;
    private TextView tvName;
    private TextView tvDesc;
    private TextView tvAdd;
    private Place place;
    private ListView eventList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        eventList = (ListView) findViewById(R.id.eventList);

        List<Event> evList = EventDB.getEvents();

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_events, evList);
        eventList.setAdapter(adapter);

        tvName = (TextView) findViewById(R.id.single_name);
        tvDesc = (TextView) findViewById(R.id.single_desc);
        tvAdd = (TextView) findViewById(R.id.single_add);
        ivLogo = (ImageView) findViewById(R.id.icon_single);

        Intent i = getIntent();
        place = (Place) i.getParcelableExtra("Place");

        getSupportActionBar().setTitle(place.getName());
        tvName.setText(place.getName());
        tvDesc.setText(place.getDesc());
        tvAdd.setText(place.getAddress());

        int imageResource = getResources().getIdentifier("@drawable/"+place.getFoto(), null, this.getPackageName());
        ivLogo.setImageResource(imageResource);

        localizeImageView = (ImageView) findViewById(R.id.localize);
    }

    public void startMap(View view){
        final Intent intentEvent = new Intent(this, MapActivity.class);
        intentEvent.putExtra("latitude",place.getLongitude());
        intentEvent.putExtra("longitude",place.getLatitude());
        intentEvent.putExtra("mainMode","Single");
        startActivity(intentEvent);
    }

    public void startRoad(View view){
        //TODO putExtra
        final Intent intentTrack = new Intent(this, TrackActivity.class);
        startActivity(intentTrack);
    }
}
