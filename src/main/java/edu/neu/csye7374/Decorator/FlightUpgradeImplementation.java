// package edu.neu.csye7374.Decorator;

// import edu.neu.csye7374.Booking;

// public class FlightUpgradeImplementation implements FlightUpgradeOptions {
//     Booking booking;
//     public FlightUpgradeImplementation(Booking booking) {
//         super();
//         this.booking = booking;
//     }
//     // @Override
//     // public double getBasePrice() {
//     //     return this.booking.getFlight().getPrice();
//     // }
//     @Override
//     public double getBasePrice() {
//         return booking.getPrice(); // Retrieve the base price from the booking
//     }
//     @Override
//     public String getUpgradeDescription() {
//         return "Flight Upgrade";
//     }
// }
package edu.neu.csye7374.Decorator;

import edu.neu.csye7374.Booking;

public class FlightUpgradeImplementation implements FlightUpgradeOptions {
    Booking booking;

    public FlightUpgradeImplementation(Booking booking) {
        this.booking = booking;
    }

    @Override
    public double getBasePrice() {
        return booking.getPrice(); // Retrieve price directly from booking
    }

    @Override
    public String getUpgradeDescription() {
        return "Base Booking";
    }
}
