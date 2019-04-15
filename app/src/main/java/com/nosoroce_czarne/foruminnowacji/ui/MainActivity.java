package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.mockDB.PlaceDB;
import com.nosoroce_czarne.foruminnowacji.model.Place;

public class MainActivity extends AppCompatActivity {
    private Button events;
    private Button event;
    private Button places;
    private Button single;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
