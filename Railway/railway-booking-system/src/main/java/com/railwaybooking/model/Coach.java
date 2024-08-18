package com.railwaybooking.model;

import java.util.List;

public class Coach {
    private int coachNumber;
    private List<Seat> seats;
    private double basePrice;

    // Constructor
    public Coach(int coachNumber, List<Seat> seats, double basePrice) {
        this.coachNumber = coachNumber;
        this.seats = seats;
        this.basePrice = basePrice;
    }

    // Getters and Setters
    public int getCoachNumber() {
        return coachNumber;
    }

    public void setCoachNumber(int coachNumber) {
        this.coachNumber = coachNumber;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public double getBasePrice() {
        return basePrice;
    }

    public void setBasePrice(double basePrice) {
        this.basePrice = basePrice;
    }
}
