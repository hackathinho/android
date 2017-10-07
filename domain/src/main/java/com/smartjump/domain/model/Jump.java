package com.smartjump.domain.model;

/**
 *
 */
public abstract class Jump {

    private final int id;

    private final float latitude;
    private final float longitude;
    private final float distance;

    private final String address;

    public Jump(int id, float latitude, float longitude, float distance, String address) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    @Override
    public String toString() {
        return "Jump{" +
                "id=" + id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", distance=" + distance +
                ", address='" + address + '\'' +
                '}';
    }
}
