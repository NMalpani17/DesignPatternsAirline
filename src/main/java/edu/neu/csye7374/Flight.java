// package edu.neu.csye7374;

// import java.util.Date;
// import edu.neu.csye7374.Interface.FlightAPI;
// import edu.neu.csye7374.Builder.FlightBuilder;

// public class Flight implements FlightAPI{
//     private int flightID;
//     private double price;
//     private Date flightDate;
//     private String startSite;
//     private String arriveSite;
//     private String currentState = "Scheduled"; // Default state

//     public Flight(FlightBuilder fb) {
//         this.flightID = fb.getFlightID();
//         this.price = fb.getPrice();
//         this.flightDate = fb.getFlightDate();
//         this.startSite = fb.getStartSite();
//         this.arriveSite = fb.getArriveSite();
//     }
//     // Getter and setter for currentState
//     public String getCurrentState() {
//         return currentState;
//     }

//     public void setCurrentState(String currentState) {
//         this.currentState = currentState;
//     }
//     public int getFlightID() {
//         return flightID;
//     }

//     public double getPrice() {
//         return price;
//     }

//     public Date getFlightDate() {
//         return flightDate;
//     }

//     public String getStartSite() {
//         return startSite;
//     }

//     public String getArriveSite() {
//         return arriveSite;
//     }

//     @Override
//     public void setPrice(double price) {
//         this.price = price;
//     }
//     @Override
//     public String toString() {
//         StringBuilder sb = new StringBuilder();
//         sb.append("Flight - "+ flightID + "\n");
//         sb.append("Price: " + price + "\n");
//         sb.append("Date: " + flightDate + "\n");
//         sb.append("Origin: " + startSite + "\n");
//         sb.append("Destination: " + arriveSite + "\n");
//         sb.append("Current State: ").append(currentState).append("\n");
//         return sb.toString();
//     }


// }
package edu.neu.csye7374;

import java.util.Date;
import edu.neu.csye7374.Interface.FlightAPI;
import edu.neu.csye7374.Builder.FlightBuilder;
import edu.neu.csye7374.State.FlightState;

public class Flight implements FlightAPI {
    private int flightID;
    private double price;
    private Date flightDate;
    private String startSite;
    private String arriveSite;
    private String currentState = "Scheduled"; // Default state
    private FlightState flightState; // To handle state transitions

    public Flight(FlightBuilder fb) {
        this.flightID = fb.getFlightID();
        this.price = fb.getPrice();
        this.flightDate = fb.getFlightDate();
        this.startSite = fb.getStartSite();
        this.arriveSite = fb.getArriveSite();
        this.flightState = new FlightState(flightID, this); // Initialize FlightState
    }

    public String getCurrentState() {
        return currentState;
    }

    public void setCurrentState(String currentState) {
        this.currentState = currentState;
    }

    public FlightState getState() {
        return flightState;
    }

    public void setState(FlightState flightState) {
        this.flightState = flightState;
    }

    public int getFlightID() {
        return flightID;
    }

    public double getPrice() {
        return price;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public String getStartSite() {
        return startSite;
    }

    public String getArriveSite() {
        return arriveSite;
    }

    @Override
    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Flight - ").append(flightID).append("\n");
        sb.append("Price: ").append(price).append("\n");
        sb.append("Date: ").append(flightDate).append("\n");
        sb.append("Origin: ").append(startSite).append("\n");
        sb.append("Destination: ").append(arriveSite).append("\n");
        sb.append("Current State: ").append(currentState).append("\n");
        return sb.toString();
    }
}
