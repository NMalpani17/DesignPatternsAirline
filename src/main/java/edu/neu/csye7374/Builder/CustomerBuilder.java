package edu.neu.csye7374.Builder;

import edu.neu.csye7374.*;


public class CustomerBuilder{
    private String firstName;
    private String lastName;
    private int birthYear;
    private int birthMonth;
    private int birthDay;
    private int customerID;
    public int getCustomerID() {
        return customerID;
    }
    public CustomerBuilder setCustomerID(int customerID) {
        this.customerID = customerID;
        return this;
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
    public CustomerBuilder setFirstName(String firstName){
        this.firstName = firstName;
        return this;
    }
    public CustomerBuilder setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }
    public CustomerBuilder setBirthYear(int birthYear) {
        this.birthYear = birthYear;
        return this;
    }
    public CustomerBuilder setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
        return this;
    }
    public CustomerBuilder setBirthDay(int birthDay){
        this.birthDay = birthDay;
        return this;
    }

    public Customers createCustomers() {
        return new Customers(this);
    }
}