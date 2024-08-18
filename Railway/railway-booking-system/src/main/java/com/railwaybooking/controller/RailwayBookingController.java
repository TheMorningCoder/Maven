package com.railwaybooking.controller;

import com.railwaybooking.model.*;
import com.railwaybooking.service.BookingService;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class RailwayBookingController {

    private Train train;
    private BookingService bookingService;

    // Constructor to initialize the train and booking service
    public RailwayBookingController() {
        this.train = initializeTrain();
        this.bookingService = new BookingService();
    }

    // Method to start the booking process
    public void startBookingProcess() {
        Scanner scanner = new Scanner(System.in);
        boolean continueBooking = true;

        System.out.println("Welcome to the Railway Booking System!");

        while (continueBooking) {
            System.out.print("Enter your name: ");
            String name = scanner.nextLine();

            System.out.print("Enter your berth preference (Lower, Middle, Upper): ");
            String berthPreference = scanner.nextLine();

            User user = new User(name, berthPreference);

            // Book a seat for the user
            Seat bookedSeat = bookingService.bookSeat(train, user);

            if (bookedSeat != null) {
                displayBookingDetails(user, bookedSeat);
            } else {
                System.out.println("Sorry, no seats are available with your preferences.");
            }

            // Ask if the user wants to book another ticket or exit
            System.out.print("Do you want to book another ticket? (yes/no): ");
            String response = scanner.nextLine();

            if (response.equalsIgnoreCase("no")) {
                continueBooking = false;
                System.out.println("Thank you for using the Railway Booking System!");
            }
        }

        scanner.close();
    }

    // Logic to display booking details
    private void displayBookingDetails(User user, Seat seat) {
        System.out.println("Booking Successful!");
        System.out.println("Passenger Name: " + user.getName());
        System.out.println("Coach Number: " + seat.getCoachNumber());
        System.out.println("Seat Number: " + seat.getSeatNumber());
        System.out.println("Berth Type: " + seat.getBerthType());
        System.out.println("Ticket Price: " + seat.getPrice());
    }

    // Method to initialize the train with coaches and seats
    private Train initializeTrain() {
        List<Coach> coaches = new ArrayList<>();

        // Initialize coaches with coach numbers and seats
        for (int i = 1; i <= 10; i++) {
            List<Seat> seats = new ArrayList<>();

            // Initialize seats for each coach
            for (int j = 1; j <= 72; j++) {
                String berthType;
                if (j % 8 == 1 || j % 8 == 4) {
                    berthType = "Lower";
                } else if (j % 8 == 2 || j % 8 == 5) {
                    berthType = "Middle";
                } else if (j % 8 == 3 || j % 8 == 6) {
                    berthType = "Upper";
                } else if (j % 8 == 7) {
                    berthType = "Side Lower";
                } else {
                    berthType = "Side Upper";
                }

                seats.add(new Seat(j, i, berthType, false, 100.0)); // Default price is set to 100.0
            }

            coaches.add(new Coach(i, seats, 100.0)); // Base price is set to 100.0 for all coaches
        }

        return new Train("Express", coaches);
    }
}
