package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.nosoroce_czarne.foruminnowacji.MapActivity;
import com.nosoroce_czarne.foruminnowacji.R;

public class  SingleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single);
        getSupportActionBar().setTitle("Teatr");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        final Intent intentEvent = new Intent(this, MapActivity.class);
        intentEvent.putExtra("latitude",50.012922);
        intentEvent.putExtra("longitude",20.986707);
        startActivity(intentEvent);
    }
}
