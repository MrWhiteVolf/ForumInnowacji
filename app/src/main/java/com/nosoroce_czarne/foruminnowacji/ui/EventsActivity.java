package com.nosoroce_czarne.foruminnowacji.ui;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.nosoroce_czarne.foruminnowacji.CustomListAdapter;
import com.nosoroce_czarne.foruminnowacji.Event;
import com.nosoroce_czarne.foruminnowacji.R;

import java.util.ArrayList;

public class EventsActivity extends AppCompatActivity {
    private ListView eventList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_listview);
        eventList = (ListView) findViewById(R.id.eventList);

        ArrayList<Event> evList = new ArrayList<>();
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));

        CustomListAdapter adapter = new CustomListAdapter(this, R.layout.activity_events, evList);
        eventList.setAdapter(adapter);
    }
}
