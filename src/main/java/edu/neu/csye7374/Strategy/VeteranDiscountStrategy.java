package edu.neu.csye7374.Strategy;

public class VeteranDiscountStrategy implements DiscountStrategyAPI {
    public static final double Veteran_Discount_Percent=0.5;

    @Override
    public double CalculateDiscount (double price) {
        double final_price= price-(Veteran_Discount_Percent*price);
        return final_price;
    }

    @Override
    public String toString(){
        String s="Veteran Discount - 50%";
        return s;

    }
}
