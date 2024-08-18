package com.railwaybooking.model;

public class Seat {
    private int seatNumber;
    private int coachNumber;
    private String berthType;
    private boolean isBooked;
    private double price;

    // Constructor
    public Seat(int seatNumber, int coachNumber, String berthType, boolean isBooked, double price) {
        this.seatNumber = seatNumber;
        this.coachNumber = coachNumber;
        this.berthType = berthType;
        this.isBooked = isBooked;
        this.price = price;
    }

    // Getters and Setters
    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber) {
        this.seatNumber = seatNumber;
    }

    public int getCoachNumber() {
        return coachNumber;
    }

    public void setCoachNumber(int coachNumber) {
        this.coachNumber = coachNumber;
    }

    public String getBerthType() {
        return berthType;
    }

    public void setBerthType(String berthType) {
        this.berthType = berthType;
    }

    public boolean isBooked() {
        return isBooked;
    }

    public void setBooked(boolean isBooked) {
        this.isBooked = isBooked;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
