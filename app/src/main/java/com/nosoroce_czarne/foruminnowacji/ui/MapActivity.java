package com.nosoroce_czarne.foruminnowacji.ui;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import com.nosoroce_czarne.foruminnowacji.mockDB.PlaceDB;
import com.nosoroce_czarne.foruminnowacji.model.Place;
import com.nosoroce_czarne.foruminnowacji.util.LocationsDB;
import com.nosoroce_czarne.foruminnowacji.R;

import java.util.Map;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_map);
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }


    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        Intent intent = getIntent();
        String mode = intent.getStringExtra("mainMode");
        Double latitude = intent.getDoubleExtra("latitude", 1.0);
        Double longitude = intent.getDoubleExtra("longitude", 1.0);
        // Add a marker in Sydney and move the camera

        if (mode.equals("Main")) {
            for (Place entry : new PlaceDB().getPlaces()) {
                LatLng latLng = new LatLng(entry.getLatitude(), entry.getLongitude());
                mMap.addMarker(new MarkerOptions().position(latLng).title(entry.getName()));
                mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17), 1500, null);
            }
        } else if(mode.equals("Single")){
            mMap.addMarker(new MarkerOptions().position(new LatLng(latitude, longitude)).title("Cycory"));
            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitude, longitude), 17), 1500, null);
        }
    }
}

