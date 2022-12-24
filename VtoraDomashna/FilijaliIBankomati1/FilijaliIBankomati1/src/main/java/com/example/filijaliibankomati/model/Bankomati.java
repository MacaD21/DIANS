package com.example.filijaliibankomati.model;

import lombok.Data;

@Data
public class Bankomati {
    String address;
    String id;
    String lat;
    String lon;
    String name;
    String city;

    public Bankomati(String address, String id, String lat, String lon, String name, String city) {
        this.address = address;
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.name = name;
        this.city = city;
    }

    public String getAddress() {
        return address;
    }


    public String getId() {
        return id;
    }

    public String getLat() {
        return lat;
    }

    public String getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
