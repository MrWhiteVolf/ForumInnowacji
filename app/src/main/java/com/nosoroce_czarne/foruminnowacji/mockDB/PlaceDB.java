package com.nosoroce_czarne.foruminnowacji.mockDB;

import com.nosoroce_czarne.foruminnowacji.model.Place;

import java.util.ArrayList;
import java.util.List;

public class PlaceDB {

    static List<Place> places = new ArrayList<>();

    static {
        places.add(new Place("ID0","Teatr im. Ludwika Solskiego w Tarnowie", "Teatr im. Ludwika Solskiego w Tarnowie – samorządowa instytucja kultury m. Tarnowa, teatr dramatyczny działający od 1945 w budynku byłego Polskiego Towarzystwa Gimnastycznego „Sokół”", "teatr", "ul. Mickiewicza 4", 50.0158, 20.9875));
        places.add(new Place("ID1","בימת בית הכנסת", "Żydowskie konstrukcje", "foto", "33-100, 42-600 Tarnów", 50.013340, 20.988942));
        places.add(new Place("ID2","Turystyczna Izba Pamięci", "Turystyczna Izba Pamięci", "foto", "Żydowska 20, 33-100 Tarnów", 50.013083, 20.990318));
        places.add(new Place("ID3","Muzeum Diecezjalne", "Muzeum Diecezjalne", "foto", "plac Katedralny 6, 33-100 Tarnów", 50.012912, 20.986726));
        places.add(new Place("ID4","Dawna siedziba Gestapo", "Dawna siedziba Gestapo", "foto", "Tarnów, 33-100 Tarnów ul, Urszulańska, 33-100 Tarnów", 50.008512, 20.983409));
        places.add(new Place("ID5","Muzeum Etnograficzne", "Muzeum Etnograficzne", "foto", "Krakowska 10, 33-100 Tarnów", 50.010865, 20.983265));
        places.add(new Place("ID6","Ratusz – Galeria Sztuki Dawnej", "Ratusz – Galeria Sztuki Dawnej", "foto", "Rynek 1, 33-100 Tarnów", 50.012451, 20.988377));
        places.add(new Place("ID7","Siedziba Muzeum Okręgowego w Tarnowie", "Siedziba Muzeum Okręgowego w Tarnowie", "foto", "Rynek 3, 33-100 Tarnów", 50.012469, 20.987681));
        places.add(new Place("ID8","Galeria „Panorama”", "Galeria „Panorama”", "foto", "Plac Dworcowy 4, 33-100 Tarnów", 50.005760, 20.974464));
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
