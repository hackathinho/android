package com.smartjump.data.entity;

/**
 *
 */
public class Location {

    private final double latitude;
    private final double longitude;
    private final double precision;

    public Location(double latitude, double longitude, double precision) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public double getPrecission() {
        return precision;
    }
}
