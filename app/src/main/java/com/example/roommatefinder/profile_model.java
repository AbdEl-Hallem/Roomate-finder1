package com.example.roommatefinder;

public class profile_model {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public profile_model(String name) {
        this.name = name;
    }

    private String name;
    public profile_model() {
    }
}
