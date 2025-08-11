package edu.neu.csye7374.Command;

import edu.neu.csye7374.Booking;

public class CancelTicketCommand implements Command {
    private Booking ticketReceiver;

    public CancelTicketCommand(Booking ticketReceiver) {
        this.ticketReceiver = ticketReceiver;
    }

    @Override
    public void execute() {
        ticketReceiver.cancelTicket();
    }
}
