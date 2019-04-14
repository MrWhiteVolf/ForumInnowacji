package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.nosoroce_czarne.foruminnowacji.CustomListAdapter;
import com.nosoroce_czarne.foruminnowacji.Event;
import com.nosoroce_czarne.foruminnowacji.MapActivity;
import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.model.Place;

import java.util.ArrayList;

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

        ArrayList<Event> evList = new ArrayList<>();
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomi22 Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));
        evList.add(new Event("drawable://" +R.drawable.hehe, "Bartłomiej Wnuk", "DUAP", "DUPA"));

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
        //TODO dodanie putExtra
        final Intent intentEvent = new Intent(this, MapActivity.class);
        intentEvent.putExtra("latitude",place.getX());
        intentEvent.putExtra("longitude",place.getY());
        intentEvent.putExtra("mainMode","Single");
        startActivity(intentEvent);
    }
}
