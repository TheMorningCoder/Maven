package com.railwaybooking.model;

import java.util.List;

public class Train {
    private String name;
    private List<Coach> coaches;

    // Constructor
    public Train(String name, List<Coach> coaches) {
        this.name = name;
        this.coaches = coaches;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public void setCoaches(List<Coach> coaches) {
        this.coaches = coaches;
    }
}
