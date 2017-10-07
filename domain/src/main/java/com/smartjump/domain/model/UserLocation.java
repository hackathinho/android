package com.smartjump.domain.model;

/**
 *
 */
public class UserLocation {

    private final double latitude;
    private final double longitude;
    private final double precision;

    public UserLocation(double latitude, double longitude, float precision) {
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

    public double getPrecision() {
        return precision;
    }
}
