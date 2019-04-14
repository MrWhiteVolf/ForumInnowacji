package com.nosoroce_czarne.foruminnowacji;

import com.google.android.gms.maps.model.LatLng;

import java.util.HashMap;

public class LocationsDB {

    private static HashMap<String, LatLng> locations = new HashMap<String, LatLng>();

    static {
        locations.put("cycorlewy", new LatLng(50.012922, 20.986707));
        locations.put("cycorprawy", new LatLng(50.012250, 20.986645));
        locations.put("pitoklewy", new LatLng(50.012986, 20.987455));
        locations.put("pitokprawy", new LatLng(50.013342, 20.990255));
        locations.put("dupa", new LatLng(49.999694, 20.997938));
    }

    public HashMap<String, LatLng> getLocations() {
        return locations;
    }
}
