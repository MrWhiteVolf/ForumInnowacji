package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.nosoroce_czarne.foruminnowacji.MapActivity;
import com.nosoroce_czarne.foruminnowacji.R;
import com.nosoroce_czarne.foruminnowacji.model.Place;

public class  SingleActivity extends AppCompatActivity {
    private ImageView localizeImageView;
    private ImageView ivLogo;
    private TextView tvName;
    private TextView tvDesc;
    private TextView tvAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intentEvent = new Intent(this, MapActivity.class);
        intentEvent.putExtra("latitude",50.012922);
        intentEvent.putExtra("longitude",20.986707);
        startActivity(intentEvent);

        tvName = (TextView) findViewById(R.id.single_name);
        tvDesc = (TextView) findViewById(R.id.single_desc);
        tvAdd = (TextView) findViewById(R.id.single_add);
        ivLogo = (ImageView) findViewById(R.id.icon_single);

        Intent i = getIntent();
        Place place = (Place) i.getParcelableExtra("Place");

        getSupportActionBar().setTitle(place.getName());
        tvName.setText(place.getName());
        tvDesc.setText(place.getDesc());
        tvAdd.setText(place.getAddress());
        String path = "R.drawable." + place.getFoto();
        ivLogo.setImageDrawable(Drawable.createFromPath(place.getFoto()));

        localizeImageView = (ImageView) findViewById(R.id.localize);
    }

    public void startMap(View view){
        //TODO dodanie putExtra
        final Intent intentEvent = new Intent(this, MapActivity.class);
    }
}
