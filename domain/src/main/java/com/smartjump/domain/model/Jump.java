package com.smartjump.domain.model;

/**
 *
 */
public abstract class Jump {

    private final int id;

    private final float latitude;
    private final float longitude;
    private final float distance;

    public Jump(int id, float latitude, float longitude, float distance) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
    }

    public int getId() {
        return id;
    }

    public float getLatitude() {
        return latitude;
    }

    public float getLongitude() {
        return longitude;
    }

    public float getDistance() {
        return distance;
    }
}
