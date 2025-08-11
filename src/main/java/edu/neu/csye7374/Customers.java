package edu.neu.csye7374;
import edu.neu.csye7374.Builder.CustomerBuilder;
import edu.neu.csye7374.Interface.PersonAPI;

public class Customers implements PersonAPI{
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int customerID;


    public Customers(CustomerBuilder customers){
        this.firstName = customers.getFirstName();
        this.lastName = customers.getLastName();
        this.birthYear = customers.getBirthYear();
        this.birthMonth = customers.getBirthMonth();
        this.birthDay = customers.getBirthDay();
        this.customerID = customers.getCustomerID();
    }

    public int getCustomerID() {
        return customerID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public int getBirthDay() {
        return birthDay;
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Customer Name: " + this.firstName + " " + this.lastName + "\n");
        sb.append("Customer ID: " + customerID + "\n");
        sb.append("Customer Birthday: " + birthDay + "-" + birthMonth + "-" + birthYear + "\n");
        return sb.toString();
    }


}
