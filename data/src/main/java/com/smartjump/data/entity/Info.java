package com.smartjump.data.entity;

/**
 *
 */
public class Info {

    private final String name;
    private final String address;

    public Info(String name, String address) {
        this.name = name;
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }
}
