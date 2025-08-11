// package edu.neu.csye7374.State;

// public class FlightInTransit implements FlightStateAPI{
//     public static FlightState flightState;

//     public FlightInTransit(FlightState flightState) {
//         this.flightState = flightState;
//     }

//     @Override
//     public void onBoarding() {
//         System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is already In Transit.");
//     }

//     @Override
//     public void inTransit() {
//         System.out.println("FLight - " +flightState.getFlightID() + " Already in Transit!");
//     }

//     @Override
//     public void delay() {
//         System.out.println("ERROR: Cannot change to 'Delayed' state. Flight is In Transit.");
//     }

//     @Override
//     public void cancelled() {
//         System.out.println("ERROR: Cannot change to 'Cancelled' state. Flight is In Transit.");
//     }


//     @Override
//     public void offboarding() {
//         flightState.setState(flightState.getOffBoarding());
//         System.out.println("Flight - "+ flightState.getFlightID()+" is offBoarding.");
//     }
// }
package edu.neu.csye7374.State;

import edu.neu.csye7374.Flight;

public class FlightInTransit implements FlightStateAPI {
    private FlightState flightState;
    private Flight flight;

    public FlightInTransit(FlightState flightState, Flight flight) {
        this.flightState = flightState;
        this.flight = flight;
    }

    @Override
    public void onBoarding() {
        System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is already In Transit.");
    }

    @Override
    public void inTransit() {
        System.out.println("FlightID: " + flightState.getFlightID() + " is already In Transit!");
    }

    @Override
    public void delay() {
        flightState.setState(flightState.getDelayed());
        flight.setCurrentState("Delayed");
        System.out.println("FlightID: " + flightState.getFlightID() + " is now Delayed.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        flight.setCurrentState("Cancelled");
        System.out.println("FlightID: " + flightState.getFlightID() + " is now Cancelled.");
    }

    @Override
    public void offboarding() {
        flightState.setState(flightState.getOffBoarding());
        flight.setCurrentState("Off Boarding");
        System.out.println("FlightID: " + flightState.getFlightID() + " is now Off Boarding.");
    }
}
