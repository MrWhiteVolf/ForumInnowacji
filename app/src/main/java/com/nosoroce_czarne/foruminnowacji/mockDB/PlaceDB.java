package com.nosoroce_czarne.foruminnowacji.mockDB;

import com.nosoroce_czarne.foruminnowacji.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceDB {

    static List<Place> places = new ArrayList<>();

    static {
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        places.add(new Place("ID1","name", "desc", "foto", "address", 50.0000, 20.0000));
        }

    public static List<Place> getPlaces() {
        return places;
    }

    public static Place getPlaceByID(String ID){
        for (Place place: places) {
            if(place.getID().equals(ID)){
                return place;
            }
        }
        return null;
    }
}
