package com.railwaybooking.model;

public class User {
    private String name;
    private String berthPreference;

    // Constructor
    public User(String name, String berthPreference) {
        this.name = name;
        this.berthPreference = berthPreference;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getBerthPreference() {
        return berthPreference;
    }

    public void setBerthPreference(String berthPreference) {
        this.berthPreference = berthPreference;
    }
}
