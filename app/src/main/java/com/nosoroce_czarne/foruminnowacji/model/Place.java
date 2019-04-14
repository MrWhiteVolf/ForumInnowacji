package com.nosoroce_czarne.foruminnowacji.model;

public class Place {
    private String name;
    private String desc;
    private String foto;
    private String address;
    private double x;
    private double y;

    public Place(String name, String desc, String foto, String address, double x, double y) {
        this.name = name;
        this.desc = desc;
        this.foto = foto;
        this.address = address;
        this.x = x;
        this.y = y;
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

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
