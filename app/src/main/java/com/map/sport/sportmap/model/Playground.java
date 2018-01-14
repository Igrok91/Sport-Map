package com.map.sport.sportmap.model;

/**
 * Created by Igor on 13.01.2018.
 */

public class Playground {
    private String name;
    private String address;
    private PlaygroundType kind;

    public Playground(String name, PlaygroundType kind) {
        this.name = name;
        this.kind = kind;
    }

    public PlaygroundType getKind() {
        return kind;
    }

    public void setKind(PlaygroundType kind) {
        this.kind = kind;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
