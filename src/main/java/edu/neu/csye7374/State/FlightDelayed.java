// package edu.neu.csye7374.State;

// public class FlightDelayed implements FlightStateAPI{
//     public static FlightState flightState;

//     public FlightDelayed(FlightState flightState) {
//         this.flightState = flightState;
//     }

//     @Override
//     public void onBoarding() {
//         flightState.setState(flightState.getFlightOnBoarding());
//         System.out.println("Apologies for the delay\n FlightID: "+ flightState.getFlightID() + " is now On Boarding.");
//     }

//     @Override
//     public void inTransit() {
//         System.out.println("ERROR: Cannot change to 'In Transit' state. Flight is Delayed.");
//     }

//     @Override
//     public void delay() {
//         System.out.println("Flight" + flightState.getFlightID() + " is already Delayed.");
//     }

//     @Override
//     public void cancelled() {
//         flightState.setState(flightState.getCancelled());
//         System.out.println("Flight - "+ flightState.getFlightID() + " is Cancelled.");
//     }

//     @Override
//     public void offboarding() {
//         flightState.setState(flightState.getOffBoarding());
//         System.out.println("Apologies for the delay\n Flight - "+flightState.getFlightID() +" is now Off Boarding.");
//     }
// }

package edu.neu.csye7374.State;

import edu.neu.csye7374.Flight;

public class FlightDelayed implements FlightStateAPI {
    private FlightState flightState;
    private Flight flight;

    public FlightDelayed(FlightState flightState, Flight flight) {
        this.flightState = flightState;
        this.flight = flight;
    }

    @Override
    public void onBoarding() {
        System.out.println("ERROR: Cannot change to 'On Boarding' state. Flight is Delayed.");
    }

    @Override
    public void inTransit() {
        flightState.setState(flightState.getInTransit());
        flight.setCurrentState("In Transit");
        System.out.println("FlightID: " + flightState.getFlightID() + " is now In Transit.");
    }

    @Override
    public void delay() {
        System.out.println("FlightID: " + flightState.getFlightID() + " is already Delayed.");
    }

    @Override
    public void cancelled() {
        flightState.setState(flightState.getCancelled());
        flight.setCurrentState("Cancelled");
        System.out.println("FlightID: " + flightState.getFlightID() + " is now Cancelled.");
    }

    @Override
    public void offboarding() {
        System.out.println("ERROR: Cannot change to 'Off Boarding' state. Flight is Delayed.");
    }
}
