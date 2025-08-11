package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;

public class SeatChangeFeature implements TicketFeature {
    private String seatNumber;

    public SeatChangeFeature(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    @Override
    public void applyFeature(Booking ticket) {
        System.out.println("Applying seat change: " + seatNumber);
        ticket.setSeatNumber(seatNumber);
    }
}
