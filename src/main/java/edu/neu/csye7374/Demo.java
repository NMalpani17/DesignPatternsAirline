package edu.neu.csye7374;

import edu.neu.csye7374.Decorator.*;
import edu.neu.csye7374.Facade.SaveAndLoadFacadeAPI;
import edu.neu.csye7374.Facade.SaveAndLoadToLocal;
import edu.neu.csye7374.Factory.*;
import edu.neu.csye7374.Interface.*;
//import edu.neu.csye7374.Prototype.AirlineTicket;
import edu.neu.csye7374.Builder.*;
import edu.neu.csye7374.Command.BookTicketCommand;
import edu.neu.csye7374.Command.CancelTicketCommand;
import edu.neu.csye7374.Command.Command;
import edu.neu.csye7374.Command.TicketInvoker;
import edu.neu.csye7374.Strategy.*;
import edu.neu.csye7374.State.*;
import edu.neu.csye7374.Adapter.*;
import edu.neu.csye7374.Bridge.MealPreferenceFeature;
import edu.neu.csye7374.Bridge.SeatChangeFeature;
import edu.neu.csye7374.Bridge.TicketFeature;
import edu.neu.csye7374.Util.CSVHandler;
import edu.neu.csye7374.Util.FileHandlerAPI;
import edu.neu.csye7374.Observer.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Demo {

    private static Airline deltaAirline;
    private static List<FlightAPI> flights = new ArrayList<>();
    private static List<PersonAPI> customers = new ArrayList<>();
    private static List<Booking> bookings = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws ParseException {
        initializeAirline();
        runMenu();
    }


    private static void initializeAirline() {
        AirlineFactory airlineFactory = AirlineFactory.getInstance();
        deltaAirline = airlineFactory.getObject();
        deltaAirline.setAirlineName("Delta");
        System.out.println("\n[Singleton Factory Design Pattern] Airline instance created: " + deltaAirline.getAirLineName());
    }

    private static void runMenu() {
        int choice;

        do {
            System.out.println("\n=== Airline Booking System ===");
            System.out.println("1. Add Flight (Builder Pattern)");
            System.out.println("2. Add Customer (Builder Pattern)");
            System.out.println("3. Book a Flight (Command Pattern)");
            System.out.println("4. Cancel a Booking (Command Pattern)");
            System.out.println("5. Apply Discounts (Strategy Pattern)");
            System.out.println("6. Add Upgrades (Decorator Pattern)");
            System.out.println("7. Change Flight State (State Pattern)");
            System.out.println("8. Handle Seat/Meal Features (Bridge Pattern)");
            System.out.println("9. Notify on Booking Status Change (Observer Pattern)");
            System.out.println("10. Convert Currency (Adapter Pattern)");
            System.out.println("11. Save Data (Facade Pattern)");
            System.out.println("12. Load Data (Facade Pattern)");
            System.out.println("13. View All Flights");
            System.out.println("14. View All Customers");
            System.out.println("15. View Bookings");
            System.out.println("16. Clone Booking (Prototype Pattern)");
            System.out.println("17. Exit");
            System.out.print("Enter your choice: ");

            choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline

            switch (choice) {
                case 1 -> addFlight();
                case 2 -> addCustomer();
                case 3 -> bookFlight();
                case 4 -> cancelBooking();
                case 5 -> applyDiscounts();
                case 6 -> addUpgrades();
                case 7 -> changeFlightState();
                case 8 -> handleSeatMealFeatures();
                case 9 -> notifyOnStatusChange();
                case 10 -> convertCurrency();
                case 11 -> saveData();
                case 12 -> loadData();
                case 13 -> viewAllFlights();
                case 14 -> viewAllCustomers();
                case 15 -> viewBookings();
                case 16 -> cloneBooking();
                case 17 -> System.out.println("Exiting... Goodbye!");
                default -> System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 17);

        scanner.close();
    }

    private static void addFlight() {
        System.out.print("Enter Flight ID: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Origin: ");
        String origin = scanner.nextLine();
        System.out.print("Enter Destination: ");
        String destination = scanner.nextLine();
        System.out.print("Enter Price: ");
        double price = scanner.nextDouble();
        scanner.nextLine();
        System.out.print("Enter Date (MM-dd-yyyy): ");
        String dateInput = scanner.nextLine();

        try {
            Date date = new SimpleDateFormat("MM-dd-yyyy").parse(dateInput);
            FlightAPI flight = new FlightBuilder()
                    .setFlightID(flightId)
                    .setStartSite(origin)
                    .setArriveSite(destination)
                    .setPrice(price)
                    .setFlightDate(date)
                    .createFlight();
            flights.add(flight);
            System.out.println("[Builder Design Pattern] Flight added successfully: " + flight);
        } catch (ParseException e) {
            System.out.println("Invalid date format. Please try again.");
        }
    }

    private static void addCustomer() {
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter First Name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter Birth Year: ");
        int birthYear = scanner.nextInt();
        System.out.print("Enter Birth Month: ");
        int birthMonth = scanner.nextInt();
        System.out.print("Enter Birth Day: ");
        int birthDay = scanner.nextInt();
        scanner.nextLine();

        PersonAPI customer = new CustomerBuilder()
                .setCustomerID(customerId)
                .setFirstName(firstName)
                .setLastName(lastName)
                .setBirthYear(birthYear)
                .setBirthMonth(birthMonth)
                .setBirthDay(birthDay)
                .createCustomers();
        customers.add(customer);
        System.out.println("[Builder Design Pattern] Customer added successfully: " + customer);
    }

    private static void bookFlight() {
        if (flights.isEmpty() || customers.isEmpty()) {
            System.out.println("No flights or customers available for booking. Please add them first.");
            return;
        }
        System.out.print("Enter Flight ID to book: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter Customer ID: ");
        int customerId = scanner.nextInt();
        scanner.nextLine();
    
        FlightAPI flight = flights.stream()
                .filter(f -> f.getFlightID() == flightId)
                .findFirst()
                .orElse(null);
        PersonAPI customer = customers.stream()
                .filter(c -> c.getCustomerID() == customerId)
                .findFirst()
                .orElse(null);
    
        if (flight == null || customer == null) {
            System.out.println("Invalid Flight ID or Customer ID.");
            return;
        }
    
        Booking booking = new Booking();
        booking.setFlight(flight);
        booking.setCustomer(customer);
        booking.setBookingId(bookings.size() + 1);
        booking.setPrice(flight.getPrice()); // Initialize the booking price from the flight price
        bookings.add(booking);
    
        // Command Pattern for Booking
        Command bookCommand = new BookTicketCommand(booking);
        TicketInvoker invoker = new TicketInvoker();
        invoker.setCommand(bookCommand);
        invoker.executeCommand();
    
        System.out.println("[Command Design Pattern] Booking confirmed for " + customer.getFirstName() + " on flight " + flightId);
    }

    private static void cancelBooking() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available to cancel.");
            return;
        }
        System.out.print("Enter Booking ID to cancel: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();
    
        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);
    
        if (booking == null) {
            System.out.println("Invalid Booking ID.");
            return;
        }
    
        // Remove booking from the list
        bookings.remove(booking);
        System.out.println("[Command Design Pattern] Booking ID " + bookingId + " has been canceled and removed.");
    
        // Persist the change in data
        deltaAirline.saveBookings(bookings);
        System.out.println("Booking data updated successfully.");
    }
    

    private static void saveData() {
        if (flights.isEmpty() || customers.isEmpty()) {
            System.out.println("No flights or customers to save.");
            return;
        }
        FileHandlerAPI csvHandler = new CSVHandler();
        SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);
        deltaAirline.setDataHandler(dataHandler);
        deltaAirline.saveFlights(flights);
        deltaAirline.saveCustomers(customers);
        deltaAirline.saveBookings(bookings);
        System.out.println("[Facade Design Pattern] Data saved successfully.");
    }

    private static void loadData() {
        FileHandlerAPI csvHandler = new CSVHandler();
        SaveAndLoadFacadeAPI dataHandler = new SaveAndLoadToLocal(csvHandler);
        deltaAirline.setDataHandler(dataHandler);
        deltaAirline.loadData();

        flights = deltaAirline.getFlights();
        customers = deltaAirline.getCustomers();
        bookings = deltaAirline.getBookings();

        System.out.println("[Facade Design Pattern] Data loaded successfully.");
    }

    private static void handleSeatMealFeatures() {
        if (bookings.isEmpty()) {
            System.out.println("No bookings available.");
            return;
        }
        System.out.print("Enter Booking ID: ");
        int bookingId = scanner.nextInt();
        scanner.nextLine();

        Booking booking = bookings.stream()
                .filter(b -> b.getBookingId() == bookingId)
                .findFirst()
                .orElse(null);

        if (booking == null) {
            System.out.println("Invalid Booking ID.");
            return;
        }

        System.out.print("Enter Seat Change (e.g., 14A): ");
        String seat = scanner.nextLine();
        TicketFeature seatFeature = new SeatChangeFeature(seat);
        booking.setFeature(seatFeature);
        booking.applyFeature();

        System.out.print("Enter Meal Preference (e.g., Vegetarian): ");
        String meal = scanner.nextLine();
        TicketFeature mealFeature = new MealPreferenceFeature(meal);
        booking.setFeature(mealFeature);
        booking.applyFeature();

        System.out.println("[Bridge Design Pattern] Seat and meal preferences updated for Booking ID: " + bookingId);
    }

    private static void applyDiscounts() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        System.out.print("Enter Flight ID to apply discount: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();
    
        FlightAPI flight = flights.stream()
                .filter(f -> f.getFlightID() == flightId)
                .findFirst()
                .orElse(null);
    
        if (flight == null) {
            System.out.println("Invalid Flight ID.");
            return;
        }
    
        System.out.println("Available Discounts:");
        System.out.println("1. Christmas Discount (10%)");
        System.out.println("2. Veteran Discount (50%)");
        System.out.println("3. Summer Promo ($150 off)");
        System.out.print("Select a discount option: ");
        int discountChoice = scanner.nextInt();
        scanner.nextLine();
    
        DiscountStrategyAPI discount;
        switch (discountChoice) {
            case 1 -> discount = new ChristmasDiscountStrategy();
            case 2 -> discount = new VeteranDiscountStrategy();
            case 3 -> discount = new SummerPromoStrategy();
            default -> {
                System.out.println("Invalid choice. No discount applied.");
                return;
            }
        }
    
        double oldPrice = flight.getPrice();
        flight.setPrice(discount.CalculateDiscount(flight.getPrice()));
        System.out.printf("[Strategy Design Pattern] Discount applied. Old Price: $%.2f, New Price: $%.2f%n", oldPrice, flight.getPrice());
    }

    private static void changeFlightState() {
        if (flights.isEmpty()) {
            System.out.println("No flights available.");
            return;
        }
        System.out.print("Enter Flight ID to change state: ");
        int flightId = scanner.nextInt();
        scanner.nextLine();
    
        Flight flight = flights.stream()
                .filter(f -> f instanceof Flight && f.getFlightID() == flightId)
                .map(f -> (Flight) f)
                .findFirst()
                .orElse(null);
    
        if (flight == null) {
            System.out.println("Invalid Flight ID.");
            return;
        }
    
        FlightState state = flight.getState(); // Retrieve the existing state of the flight
        System.out.println("Available State Transitions:");
        System.out.println("1. On Boarding");
        System.out.println("2. In Transit");
        System.out.println("3. Delayed");
        System.out.println("4. Cancelled");
        System.out.println("5. Off Boarding");
        System.out.print("Select a state transition: ");
        int stateChoice = scanner.nextInt();
        scanner.nextLine();
    
        switch (stateChoice) {
            case 1 -> {
                state.onBoarding();
                flight.setCurrentState("On Boarding");
            }
            case 2 -> {
                state.inTransit();
                flight.setCurrentState("In Transit");
            }
            case 3 -> {
                state.delay();
                flight.setCurrentState("Delayed");
            }
            case 4 -> {
                state.cancelled();
                flight.setCurrentState("Cancelled");
            }
            case 5 -> {
                state.offboarding();
                flight.setCurrentState("Off Boarding");
            }
            default -> System.out.println("Invalid choice. No state change applied.");
        }
    
        System.out.println("[State Design Pattern] Flight state updated.");
        System.out.println("Current Flight State: " + flight.getCurrentState());
    }

    private static void notifyOnStatusChange() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings available.");
        return;
    }
    System.out.print("Enter Booking ID: ");
    int bookingId = scanner.nextInt();
    scanner.nextLine();

    Booking booking = bookings.stream()
            .filter(b -> b.getBookingId() == bookingId)
            .findFirst()
            .orElse(null);

    if (booking == null) {
        System.out.println("Invalid Booking ID.");
        return;
    }

    Observer emailObserver = new EmailObserver();
    Observer smsObserver = new SMSObserver();

    booking.addObserver(emailObserver);
    booking.addObserver(smsObserver);

    System.out.print("Enter new booking status (e.g., Baggage Drop off, Payment Confirmed): ");
    String status = scanner.nextLine();
    booking.setStatus(status);

    System.out.println("[Observer Design Pattern] Status updated and notifications sent.");
}
private static void convertCurrency() {
    if (flights.isEmpty()) {
        System.out.println("No flights available.");
        return;
    }
    System.out.print("Enter Flight ID to convert price: ");
    int flightId = scanner.nextInt();
    scanner.nextLine();

    FlightAPI flight = flights.stream()
            .filter(f -> f.getFlightID() == flightId)
            .findFirst()
            .orElse(null);

    if (flight == null) {
        System.out.println("Invalid Flight ID.");
        return;
    }

    double price = flight.getPrice();
    FlightPriceCurrency inrCurrency = new INRCurrency();
    FlightPriceCurrency cadCurrency = new CanadaCurrency();

    System.out.println("[Adapter Design Pattern] Original Price (USD): $" + price);
    inrCurrency.showcurrency(price);
    cadCurrency.showcurrency(price);
}

private static void viewAllFlights() {
    if (flights.isEmpty()) {
        System.out.println("No flights available.");
        return;
    }
    System.out.println("Flights:");
    flights.forEach(System.out::println);
}

private static void viewAllCustomers() {
    if (customers.isEmpty()) {
        System.out.println("No customers available.");
        return;
    }
    System.out.println("Customers:");
    customers.forEach(System.out::println);
}

private static void viewBookings() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings available.");
        return;
    }
    System.out.println("Bookings:");
    bookings.forEach(System.out::println);
}

private static void addUpgrades() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings available to upgrade.");
        return;
    }
    System.out.print("Enter Booking ID to upgrade: ");
    int bookingId = scanner.nextInt();
    scanner.nextLine();

    Booking booking = bookings.stream()
            .filter(b -> b.getBookingId() == bookingId)
            .findFirst()
            .orElse(null);

    if (booking == null) {
        System.out.println("Invalid Booking ID.");
        return;
    }

    double oldPrice = booking.getPrice(); // Retrieve current price

    System.out.println("Available Upgrades:");
    System.out.println("1. Premium Upgrade");
    System.out.println("2. Extra Legroom Upgrade");
    System.out.print("Select an upgrade option: ");
    int upgradeChoice = scanner.nextInt();
    scanner.nextLine();

    FlightUpgradeOptions upgradedBooking;
    switch (upgradeChoice) {
        case 1 -> upgradedBooking = new PremiumUpgrade(new FlightUpgradeImplementation(booking));
        case 2 -> upgradedBooking = new ExtraLegRoomUpgrade(new FlightUpgradeImplementation(booking));
        default -> {
            System.out.println("Invalid choice. No upgrade applied.");
            return;
        }
    }

    double newPrice = upgradedBooking.getBasePrice(); // Get the new price
    booking.setPrice(newPrice); // Update the booking's price

    System.out.println("[Decorator Design Pattern] Upgrade applied: " + upgradedBooking.getUpgradeDescription());
    System.out.printf("Old Price: $%.2f%n", oldPrice);
    System.out.printf("New Price: $%.2f%n", newPrice);
}
private static void cloneBooking() {
    if (bookings.isEmpty()) {
        System.out.println("No bookings available to clone.");
        return;
    }

    System.out.print("Enter Booking ID to clone: ");
    int bookingId = scanner.nextInt();
    scanner.nextLine();

    Booking originalBooking = bookings.stream()
            .filter(b -> b.getBookingId() == bookingId)
            .findFirst()
            .orElse(null);

    if (originalBooking == null) {
        System.out.println("Invalid Booking ID.");
        return;
    }

    Booking clonedBooking = originalBooking.cloneTicket(); // Clone the booking
    if (clonedBooking != null) {
        clonedBooking.setBookingId(bookings.size() + 1); // Assign a new Booking ID

        // Ask for new customer name
        System.out.print("Enter First Name for Cloned Booking: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter Last Name for Cloned Booking: ");
        String lastName = scanner.nextLine();

        // Create a new customer
        PersonAPI newCustomer = new CustomerBuilder()
                .setCustomerID(customers.size() + 1)
                .setFirstName(firstName)
                .setLastName(lastName)
                .createCustomers();
        customers.add(newCustomer); // Add the new customer to the list

        clonedBooking.setCustomer(newCustomer); // Assign the new customer to the cloned booking

        // Ask for new seat number
        System.out.print("Enter Seat Number for Cloned Booking: ");
        String seatNumber = scanner.nextLine();
        clonedBooking.setSeatNumber(seatNumber);

        bookings.add(clonedBooking); // Add the cloned booking to the list

        System.out.println("[Prototype Design Pattern] Booking cloned successfully.");
        System.out.println("Original Booking: " + originalBooking);
        System.out.println("Cloned Booking: " + clonedBooking);
    } else {
        System.out.println("Cloning failed.");
    }
}
}
