package edu.neu.csye7374.Observer;

public class EmailObserver implements Observer {
    @Override
    public void update(String status) {
        System.out.println("Email: Your ticket status has changed to " + status);
    }
}
