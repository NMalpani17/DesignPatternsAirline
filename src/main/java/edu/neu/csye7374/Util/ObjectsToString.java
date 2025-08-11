package edu.neu.csye7374.Util;

import java.text.SimpleDateFormat;
import java.util.List;


import edu.neu.csye7374.Booking;
import edu.neu.csye7374.Builder.*;
import edu.neu.csye7374.Interface.PersonAPI;
import edu.neu.csye7374.Interface.FlightAPI;

public class ObjectsToString {
    /*
     * ObjectsToString is used to convert flight, customer and booking data into csv Strings
     */
    public String FlightToString(FlightAPI flight) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(flight.getFlightID()) + ',');
        sb.append(String.valueOf(flight.getPrice()) + ',');
        sb.append(flight.getStartSite() + ',');
        sb.append(flight.getArriveSite() + ',');
        sb.append(new SimpleDateFormat("dd/MM/yyyy").format(flight.getFlightDate()));
//		sb.append(flight.getFlightDate().toString());
//		System.out.println(flight);
//		System.out.println(sb);
        return sb.toString();
    }

    public FlightAPI StringToFlight(String src) {
        String[] s = src.split(",");
        FlightBuilder fb = new FlightBuilder();

        try {
            fb.setFlightID(Integer.valueOf(s[0]));
            fb.setPrice(Double.valueOf(s[1]));
            fb.setStartSite(s[2]);
            fb.setArriveSite(s[3]);
            fb.setFlightDate(new SimpleDateFormat("dd/MM/yyyy").parse(s[4]));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return fb.createFlight();
    }

    public String CustomerToString(PersonAPI customer) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(customer.getCustomerID()) + ',');
        sb.append(customer.getFirstName() + ',');
        sb.append(customer.getLastName() + ',');
        sb.append(String.valueOf(customer.getBirthYear()) + ',');
        sb.append(String.valueOf(customer.getBirthMonth()) + ',');
        sb.append(String.valueOf(customer.getBirthDay()));

        return sb.toString();
    }

    public PersonAPI StringToCustomer(String src) {
        String[] s = src.split(",");
        CustomerBuilder cb = new CustomerBuilder();

        try {
            cb.setCustomerID(Integer.valueOf(s[0]));
            cb.setFirstName(s[1]);
            cb.setLastName(s[2]);
            cb.setBirthYear(Integer.valueOf(s[3]));
            cb.setBirthMonth(Integer.valueOf(s[4]));
            cb.setBirthDay(Integer.valueOf(s[5]));

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return cb.createCustomers();
    }

    public String BookingToString(Booking booking) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(booking.getBookingId()) + ',');
        sb.append(String.valueOf(booking.getFlight().getFlightID()) + ',');
        sb.append(String.valueOf(booking.getCustomer().getCustomerID()));
        return sb.toString();
    }

    public Booking StringToBooking(String bookingString, List<PersonAPI> customers, List<FlightAPI> flights) {
    if (customers == null || flights == null) {
        throw new IllegalArgumentException("Customers or flights list cannot be null.");
    }

    String[] parts = bookingString.split(",");
    if (parts.length < 3) {
        throw new IllegalArgumentException("Invalid booking string format.");
    }

    int bookingId = Integer.parseInt(parts[0]);
    int flightId = Integer.parseInt(parts[1]);
    int customerId = Integer.parseInt(parts[2]);

    FlightAPI flight = flights.stream()
            .filter(f -> f.getFlightID() == flightId)
            .findFirst()
            .orElse(null);

    PersonAPI customer = customers.stream()
            .filter(c -> c.getCustomerID() == customerId)
            .findFirst()
            .orElse(null);

    if (flight == null || customer == null) {
        throw new IllegalArgumentException(String.format("Invalid flight ID %d or customer ID %d in booking string.", flightId, customerId));
    }

    Booking booking = new Booking();
    booking.setBookingId(bookingId);
    booking.setFlight(flight);
    booking.setCustomer(customer);

    return booking;
}
}
