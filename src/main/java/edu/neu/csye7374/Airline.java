package edu.neu.csye7374;

import java.util.ArrayList;
import java.util.List;

import edu.neu.csye7374.Facade.SaveAndLoadFacadeAPI;
import edu.neu.csye7374.Interface.*;

public class Airline {
    /*
     * AirLine class to represent an AirLine company
     * Contains Lists of flights, customers, and bookings
     * Data persistence is managed via dataHandler of type SaveAndLoadFacadeAPI
     * loadData() and saveData() need to be used to load and save data respectively
     */
    private String airLineName;
    private SaveAndLoadFacadeAPI dataHandler;
    private List<FlightAPI> flights;
    private List<PersonAPI> customers;
    private List<Booking> bookings;
    private int customerCount, flightCount, bookingCount;

    public Airline() {
        // Initialize lists to avoid NullPointerException
        this.flights = new ArrayList<>();
        this.customers = new ArrayList<>();
        this.bookings = new ArrayList<>();
    }

    public SaveAndLoadFacadeAPI getDataHandler() {
        return dataHandler;
    }

    public void setDataHandler(SaveAndLoadFacadeAPI dataHandler) {
        this.dataHandler = dataHandler;
        if (airLineName != null) {
            dataHandler.setAirLine(airLineName);
        }
    }

    public List<FlightAPI> getFlights() {
        return flights;
    }

    public void setFlights(List<FlightAPI> flights) {
        this.flights = flights != null ? flights : new ArrayList<>();
        this.flightCount = this.flights.size();
    }

    public List<PersonAPI> getCustomers() {
        return customers;
    }

    public void setCustomers(List<PersonAPI> customers) {
        this.customers = customers != null ? customers : new ArrayList<>();
        this.customerCount = this.customers.size();
    }

    public List<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(List<Booking> bookings) {
        this.bookings = bookings != null ? bookings : new ArrayList<>();
        this.bookingCount = this.bookings.size();
    }

    public String getAirLineName() {
        return airLineName;
    }

    public void setAirlineName(String airLineName) {
        this.airLineName = airLineName;
        if (dataHandler != null) {
            dataHandler.setAirLine(airLineName);
        }
    }

    public void loadData() {
        if (dataHandler == null) {
            System.out.println("Error: Data handler is not set. Cannot load data.");
            return;
        }
    
        // Load flights
        this.flights = dataHandler.loadFlights();
        if (this.flights == null) {
            this.flights = new ArrayList<>();
        }
        this.flightCount = flights.size();
    
        // Load customers
        this.customers = dataHandler.loadCustomers();
        if (this.customers == null) {
            this.customers = new ArrayList<>();
        }
        this.customerCount = customers.size();
    
        // Load bookings
        this.bookings = dataHandler.loadBookings(customers, flights);
        if (this.bookings == null) {
            this.bookings = new ArrayList<>();
        }
        this.bookingCount = bookings.size();
    
        System.out.println("Data loaded successfully.");
    }

    public void saveData() {
        if (dataHandler == null) {
            System.out.println("Error: Data handler is not set. Cannot save data.");
            return;
        }

        dataHandler.saveFlights(flights);
        dataHandler.saveCustomers(customers);
        dataHandler.saveBookings(bookings);

        System.out.println("Data saved successfully.");
    }

    public void addFlight(FlightAPI flight) {
        if (flight != null) {
            flights.add(flight);
            flightCount = flights.size();
        }
    }

    public void addCustomer(PersonAPI customer) {
        if (customer != null) {
            customers.add(customer);
            customerCount = customers.size();
        }
    }

    public void addBooking(Booking booking) {
        if (booking != null) {
            bookings.add(booking);
            bookingCount = bookings.size();
        }
    }

    public void saveFlights(List<FlightAPI> flights) {
        if (dataHandler == null) {
            System.out.println("Error: Data handler is not set. Cannot save flights.");
            return;
        }

        this.setFlights(flights); // Update internal list
        dataHandler.saveFlights(this.flights);
        System.out.println("Flights saved successfully.");
    }

    public void saveCustomers(List<PersonAPI> customers) {
        if (dataHandler == null) {
            System.out.println("Error: Data handler is not set. Cannot save customers.");
            return;
        }

        this.setCustomers(customers); // Update internal list
        dataHandler.saveCustomers(this.customers);
        System.out.println("Customers saved successfully.");
    }

    public void saveBookings(List<Booking> bookings) {
        if (dataHandler == null) {
            System.out.println("Error: Data handler is not set. Cannot save bookings.");
            return;
        }

        this.setBookings(bookings); // Update internal list
        dataHandler.saveBookings(this.bookings);
        System.out.println("Bookings saved successfully.");
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Airline Name: ").append(airLineName).append("\n");
        sb.append("Customers: ").append(customers).append("\n");
        sb.append("Flights: ").append(flights).append("\n");
        sb.append("Bookings: ").append(bookings).append("\n");
        return sb.toString();
    }
}
