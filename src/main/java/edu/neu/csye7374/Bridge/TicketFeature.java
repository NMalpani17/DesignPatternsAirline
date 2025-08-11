package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;
//import edu.neu.csye7374.Prototype.AirlineTicket;
import edu.neu.csye7374.Prototype.TicketPrototype;

public interface TicketFeature {
    void applyFeature(Booking ticket);
}
