package com.nosoroce_czarne.foruminnowacji;

import android.support.v4.app.FragmentActivity;
import android.os.Bundle;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import org.w3c.dom.Entity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MapActivity extends FragmentActivity implements OnMapReadyCallback {

    private GoogleMap mMap;
    HashMap<LatLng, String> locations = new HashMap<LatLng, String>();

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

        // Add a marker in Sydney and move the camera
        locations.put(new LatLng(50.012922, 20.986707), "a");
        locations.put(new LatLng(50.012250, 20.986645), "b");
        locations.put(new LatLng(50.012986, 20.987455), "c");
        locations.put(new LatLng(50.013342, 20.990255), "d");

        for (Map.Entry<LatLng, String>entry : locations.entrySet()) {
        mMap.addMarker(new MarkerOptions().position(entry.getKey()).title(entry.getValue()));
        mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(entry.getKey(),17), 1500 , null);
        //mMap.moveCamera(CameraUpdateFactory.newLatLng(entry.getKey()));
        }
    }
}
