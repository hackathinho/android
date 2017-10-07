package com.smartjump.data.entity;

/**
 *
 */
public class Station {

    private final int id;

    private final float latitude;
    private final float longitude;
    private final float distance;

    private final String type;

    private final Info info;

    public Station(int id, float latitude, float longitude, float distance, String type, Info info) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.distance = distance;
        this.type = type;
        this.info = info;
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

    public String getType() {
        return type;
    }

    public Info getInfo() {
        return info;
    }
}
