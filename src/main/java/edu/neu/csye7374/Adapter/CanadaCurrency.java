package edu.neu.csye7374.Adapter;

public class CanadaCurrency implements FlightPriceCurrency {
    public double conversionRate = 1.37;

    @Override
    public void showcurrency(double price) {
        System.out.println("Flight Price in Canadian Dollars:" + price * conversionRate);
    }

}
