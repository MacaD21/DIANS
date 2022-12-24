package com.example.filijaliibankomati.model;

import lombok.Data;

@Data
public class Filijali {
    String address;
    String id;
    Double lat;
    Double lon;
    String name;
    String city;

    public Filijali(String address, String id, Double lat, Double lon, String name, String city) {
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

    public Double getLat() {
        return lat;
    }

    public Double getLon() {
        return lon;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }
}
