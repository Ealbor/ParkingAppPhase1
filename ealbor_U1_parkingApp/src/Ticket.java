import java.util.Date;

public class Ticket {

    private int ticketId;
    private int checkInTime;
    private int checkOutTime;
    private boolean lostTicket;


    //Basic Constructor
    Ticket() {}

    //Remember you're going to be using helper methods to create a legitimate ticket
    Ticket(int ticketId, int checkInTime) {
        this.ticketId = ticketId;
        this.checkInTime = checkInTime;
    }

    Ticket(boolean lostTicket) {
        this.lostTicket = lostTicket;
    }


//Setters
    public void setTicketId(int ticketId) {this.ticketId = ticketId;}

    public void setCheckInTime(int checkInTime) { this.checkInTime = checkInTime;}

    public void setCheckOutTime(int checkOutTime) {this.checkOutTime = checkOutTime;}


//Getters
    public int getTicketId() { return this.ticketId; }

    public int getCheckInTime() { return this.checkInTime; }

    public int getCheckOutTime() { return this.checkOutTime; }

    public boolean checkLostTicket () { return this.lostTicket; }


}