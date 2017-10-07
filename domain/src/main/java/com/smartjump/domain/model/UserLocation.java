package com.smartjump.domain.model;

/**
 *
 */
public class UserLocation {

    private final float latitude;
    private final float longitude;
    private final float precision;

    public UserLocation(float latitude, float longitude, float precision) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.precision = precision;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getPrecision() {
        return precision;
    }
}
