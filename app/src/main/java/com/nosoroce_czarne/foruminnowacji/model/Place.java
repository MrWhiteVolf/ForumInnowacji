package com.nosoroce_czarne.foruminnowacji.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Place implements Parcelable {
    private String ID;
    private String name;
    private String desc;
    private String foto;
    private String address;
    private double longitude;
    private double latitude;

    public Place(String ID,String name, String desc, String foto, String address, double latitude, double longitude) {
        this.ID = ID;
        this.name = name;
        this.desc = desc;
        this.foto = foto;
        this.address = address;
        this.longitude = longitude;
        this.latitude = latitude;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Przesyłanie obiektu miedzy intentami
     * @param parcel
     * @param i
     */
    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ID);
        parcel.writeString(name);
        parcel.writeString(desc);
        parcel.writeString(foto);
        parcel.writeString(address);
        parcel.writeDouble(longitude);
        parcel.writeDouble(latitude);
    }


    // this is used to regenerate your object. All Parcelables must have a CREATOR that implements these two methods
    public static final Parcelable.Creator<Place> CREATOR = new Parcelable.Creator<Place>() {
        public Place createFromParcel(Parcel in) {
            return new Place(in);
        }

        public Place[] newArray(int size) {
            return new Place[size];
        }
    };

    // example constructor that takes a Parcel and gives you an object populated with it's values
    private Place(Parcel in) {
        ID = in.readString();
        name = in.readString();
        desc = in.readString();
        foto = in.readString();
        address = in.readString();
        longitude = in.readDouble();
        latitude = in.readDouble();
    }
}
