package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.mockDB.EventDB;
import com.nosoroce_czarne.foruminnowacji.mockDB.PlaceDB;
import com.nosoroce_czarne.foruminnowacji.model.Event;
import com.nosoroce_czarne.foruminnowacji.model.Place;
import com.nosoroce_czarne.foruminnowacji.util.CustomListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Button events;
    private Button event;
    private Button places;
    private Button single;
    private ListView eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        eventList = (ListView) findViewById(R.id.list_main);

        new EventDB();
        List<Event> evList = EventDB.getEvents();
        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_events, evList);
        eventList.setAdapter(adapter);
    }

    public void intentEvents(View view){
        final Intent intentEvents = new Intent(this, EventsActivity.class);
        startActivity(intentEvents);
    }

    public void intentPlaces(View view){
        final Intent intentSingle = new Intent(this, SingleActivity.class);
        //@TODO przekazac odpowiednie ID miejsca
        intentSingle.putExtra("Place", new PlaceDB().getPlaceByID("ID0"));
        startActivity(intentSingle);
    }
}
