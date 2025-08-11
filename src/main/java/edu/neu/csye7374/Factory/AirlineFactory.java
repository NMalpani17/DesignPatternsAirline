package edu.neu.csye7374.Factory;
import edu.neu.csye7374.Airline;

public class AirlineFactory extends AbstractFactory {
    /*
     * Factory method pattern for AirLine object creation
     * AirLineFactory implements Eager Singleton Design pattern, since only one instance is required to create AirLine objects
     */

    public static AirlineFactory instance = new AirlineFactory();

    private AirlineFactory() {

    }

    public static AirlineFactory getInstance() {
        return instance;
    }

    public Airline getObject() {
        return new Airline();
    }


}