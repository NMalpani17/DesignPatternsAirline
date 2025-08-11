package edu.neu.csye7374.Observer;

public class SMSObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("SMS: Your ticket status is now " + status);
    }
}
