package com.nosoroce_czarne.foruminnowacji.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.nosoroce_czarne.foruminnowacji.mockDB.EventDB;
import com.nosoroce_czarne.foruminnowacji.util.CustomListAdapter;
import com.nosoroce_czarne.foruminnowacji.model.Event;
import com.nosoroce_czarne.foruminnowacji.R;

import java.util.ArrayList;
import java.util.List;

public class EventsActivity extends AppCompatActivity {
    private ListView eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listview);
        eventList = (ListView) findViewById(R.id.eventList);

        new EventDB();
        List<Event> evList = EventDB.getEvents();

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_events, evList);
        eventList.setAdapter(adapter);
    }
}
