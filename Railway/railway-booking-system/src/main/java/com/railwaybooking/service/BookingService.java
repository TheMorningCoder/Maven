package com.railwaybooking.service;

import com.railwaybooking.model.*;

import java.util.List;

public class BookingService {

    // Method to book a seat based on the user's berth preference and dynamic pricing
    public Seat bookSeat(Train train, User user) {
        // Iterate over coaches in the preferred order: 1, 3, 5, 7, 9, 10, 2, 4, 6, 8
        List<Coach> coaches = train.getCoaches();
        int[] preferredCoachOrder = {1, 3, 5, 7, 9, 10, 2, 4, 6, 8};

        for (int coachNum : preferredCoachOrder) {
            Coach coach = findCoachByNumber(coaches, coachNum);
            if (coach != null) {
                Seat availableSeat = findAvailableSeat(coach, user.getBerthPreference());
                if (availableSeat != null) {
                    // Calculate the dynamic price for this seat
                    double price = calculateDynamicPrice(coach);
                    availableSeat.setPrice(price);
                    availableSeat.setBooked(true);
                    return availableSeat;
                }
            }
        }
        return null; // No seat available
    }

    // Method to find a coach by its number
    private Coach findCoachByNumber(List<Coach> coaches, int coachNumber) {
        for (Coach coach : coaches) {
            if (coach.getCoachNumber() == coachNumber) {
                return coach;
            }
        }
        return null;
    }

    // Method to find an available seat based on berth preference
    private Seat findAvailableSeat(Coach coach, String berthPreference) {
        for (Seat seat : coach.getSeats()) {
            if (!seat.isBooked() && seat.getBerthType().equalsIgnoreCase(berthPreference)) {
                return seat;
            }
        }
        // If no seat with the preferred berth type is available, return any available seat
        for (Seat seat : coach.getSeats()) {
            if (!seat.isBooked()) {
                return seat;
            }
        }
        return null; // No available seats
    }

    // Method to calculate the dynamic price based on coach occupancy
    private double calculateDynamicPrice(Coach coach) {
        int totalSeats = coach.getSeats().size();
        int bookedSeats = (int) coach.getSeats().stream().filter(Seat::isBooked).count();
        double occupancyRate = (double) bookedSeats / totalSeats;

        double basePrice = coach.getBasePrice();

        // Adjust price based on occupancy
        if (occupancyRate >= 0.4) {
            return basePrice * 1.18; // 40% filled, increase price by 18%
        } else if (occupancyRate >= 0.35) {
            return basePrice * 1.15; // 35% filled, increase price by 15%
        } else if (occupancyRate >= 0.3) {
            return basePrice * 1.12; // 30% filled, increase price by 12%
        } else if (occupancyRate >= 0.2) {
            return basePrice * 1.10; // 20% filled, increase price by 10%
        } else {
            return basePrice; // No increase if less than 20% filled
        }
    }
}
