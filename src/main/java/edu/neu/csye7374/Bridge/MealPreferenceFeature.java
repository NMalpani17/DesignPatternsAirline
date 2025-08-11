package edu.neu.csye7374.Bridge;

import edu.neu.csye7374.Booking;
//import edu.neu.csye7374.Prototype.AirlineTicket;
import edu.neu.csye7374.Prototype.TicketPrototype;

public class MealPreferenceFeature implements TicketFeature {
    private String mealPreference;

    public MealPreferenceFeature(String mealPreference) {
        this.mealPreference = mealPreference;
    }

    @Override
    public void applyFeature(Booking ticket) {
        System.out
                .println("Applying meal preference: " + mealPreference + " to ticket for " + (ticket.getCustomer().getFirstName() + " " + ticket.getCustomer().getLastName()));
        ticket.setMealPreference(mealPreference);
    }
}
