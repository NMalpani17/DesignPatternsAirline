package edu.neu.csye7374.Adapter;

public class USCurrency  implements Currency{

    @Override
    public void showpriceCurrency(double price) {
        System.out.println("Flight Price in US Dollars:"+ price);
    }




}
