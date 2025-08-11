package edu.neu.csye7374.Command;

import edu.neu.csye7374.Booking;

import java.awt.print.Book;

public class BookTicketCommand implements Command {
    private Booking ticketReceiver;

    public BookTicketCommand(Booking ticketReceiver) {
        this.ticketReceiver = ticketReceiver;
    }

    @Override
    public void execute() {
        ticketReceiver.bookTicket();
    }
}
