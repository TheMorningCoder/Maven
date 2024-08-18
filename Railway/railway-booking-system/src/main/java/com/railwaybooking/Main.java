package com.railwaybooking;

import com.railwaybooking.controller.RailwayBookingController;

public class Main {
    public static void main(String[] args) {
        RailwayBookingController controller = new RailwayBookingController();
        controller.startBookingProcess();
    }
}
