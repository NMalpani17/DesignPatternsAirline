// package edu.neu.csye7374.State;

// public class FlightState implements FlightStateAPI{
//     private int flightID;
//     private FlightStateAPI flightOnBoarding;
//     private FlightStateAPI inTransit;
//     private FlightStateAPI offBoarding;
//     private FlightStateAPI delayed;
//     private FlightStateAPI cancelled;
//     private boolean isScheduled;
//     private FlightStateAPI state;

//     public FlightState(int flightID){
//         this.flightID= flightID;
//         this.flightOnBoarding = new FlightOnBoarding(this);
//         this.inTransit = new FlightInTransit(this);
//         this.offBoarding = new FlightOffBoarding(this);
//         this.delayed = new FlightDelayed(this);
//         this.cancelled = new FlightCancelled(this);
//         this.state = new FlightOnBoarding(this);
//         this.isScheduled=true;
//         System.out.println("Flight -"+ flightID + " is now scheduled.");
//     }


//     public boolean isScheduled() {
//         return isScheduled;
//     }


//     public void setScheduled(boolean isScheduled) {
//         this.isScheduled = isScheduled;
//     }


//     public int getFlightID() {
//         return flightID;
//     }

//     public void setFlightID(int flightID) {
//         this.flightID = flightID;
//     }

//     public FlightStateAPI getDelayed() {
//         return delayed;
//     }

//     public void setDelayed(FlightStateAPI delayed) {
//         this.delayed = delayed;
//     }

//     public FlightStateAPI getCancelled() {
//         return cancelled;
//     }

//     public void setCancelled(FlightStateAPI cancelled) {
//         this.cancelled = cancelled;
//     }

//     public FlightStateAPI getFlightOnBoarding() {
//         return flightOnBoarding;
//     }

//     public void setFlightOnBoarding(FlightStateAPI flightOnBoarding) {
//         this.flightOnBoarding = flightOnBoarding;
//     }

//     public FlightStateAPI getInTransit() {
//         return inTransit;
//     }

//     public void setInTransit(FlightStateAPI inTransit) {
//         this.inTransit = inTransit;
//     }

//     public FlightStateAPI getOffBoarding() {
//         return offBoarding;
//     }

//     public void setOffBoarding(FlightStateAPI offBoarding) {
//         this.offBoarding = offBoarding;
//     }

//     public FlightStateAPI getState() {
//         if(this.isScheduled) System.out.println("Flight - "+this.flightID+"  is scheduled.");
//         return state;
//     }

//     public void setState(FlightStateAPI state) {
//         this.isScheduled=false;
//         this.state = state;
//     }


//     @Override
//     public void onBoarding() {
//         this.state.onBoarding();
//     }

//     @Override
//     public void inTransit() {
//         this.state.inTransit();
//     }

//     @Override
//     public void offboarding() {
//         this.state.offboarding();
//     }

//     public void delay(){
//         this.state.delay();
//     }

//     public void cancelled(){
//         this.state.cancelled();
//     }

// }

package edu.neu.csye7374.State;

import edu.neu.csye7374.Flight;

public class FlightState {
    private final FlightOnBoarding onBoarding;
    private final FlightInTransit inTransit;
    private final FlightDelayed delayed;
    private final FlightCancelled cancelled;
    private final FlightOffBoarding offBoarding;

    private FlightStateAPI state;
    private final int flightID;

    public FlightState(int flightID, Flight flight) {
        this.flightID = flightID;
        this.onBoarding = new FlightOnBoarding(this, flight);
        this.inTransit = new FlightInTransit(this, flight);
        this.delayed = new FlightDelayed(this, flight);
        this.cancelled = new FlightCancelled(this, flight);
        this.offBoarding = new FlightOffBoarding(this, flight);
        this.state = this.onBoarding; // Initial state
    }

    public int getFlightID() {
        return flightID;
    }

    public void setState(FlightStateAPI state) {
        this.state = state;
    }

    public FlightStateAPI getOnBoarding() {
        return onBoarding;
    }

    public FlightStateAPI getInTransit() {
        return inTransit;
    }

    public FlightStateAPI getDelayed() {
        return delayed;
    }

    public FlightStateAPI getCancelled() {
        return cancelled;
    }

    public FlightStateAPI getOffBoarding() {
        return offBoarding;
    }

    public void onBoarding() {
        state.onBoarding();
    }

    public void inTransit() {
        state.inTransit();
    }

    public void delay() {
        state.delay();
    }

    public void cancelled() {
        state.cancelled();
    }

    public void offboarding() {
        state.offboarding();
    }
}
