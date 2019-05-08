import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class TicketManager {

        //ArrayList needed
    private ArrayList<Ticket> allTickets = new ArrayList();

    private ArrayList<Ticket> allLostTickets = new ArrayList();
        //Ticket object
    private Ticket tix;
        //Receipt Object


    TicketManager()
    {
        //activating objects
        tix = new Ticket();
    }



    //check in option calls checkIn();
    public void checkIn()
    {
        //Demo instance of a ticket object
        tix.setCheckInTime(generateEntryHour());
        tix.setTicketId(1001);
        //Remove
        System.out.println(tix.toString());
}

    public void saveTickets(boolean lostTickets, boolean closeFile)
    {
        //0 is default for checkIn prop, checkOut prop, and Id
        FileOutput ticketFile = new FileOutput("theFile");
        String record;
        ArrayList<Ticket> tickets = !lostTickets ? allTickets : allLostTickets;

        for (Ticket ticket:tickets){
            // field defaults
            int id = 0;
            int checkin = 0;
            int checkout = 0;

            if (!ticket.checkLostTicket()) {
                id = ticket.getTicketId();
                checkin = ticket.getCheckInTime();
                checkout = ticket.getCheckOutTime();
            }

            record = !ticket.checkLostTicket() ? "N" : "Y" + "," + id + "," + checkin + ","
                    + checkout;


            ticketFile.fileWrite(record);
        }
        if (closeFile) { ticketFile.fileClose(); }

    }





    public Receipt checkOut()
    {
        //Using mock data
        //Should look like tix.setCheckOutTime(generateRndCheckOutTime());
        tix.setCheckOutTime(generateExitHour());
        allTickets.add(tix);
        return new Receipt(tix);
        //close file
    }

    public Receipt checkOut(boolean lostTicket)
    {
        Ticket ticket = new Ticket(true);
        allLostTickets.add(ticket);
        return new Receipt(lostTicket);
    }


    public SummaryReport getSumReport()
    {
        return new SummaryReport(allTickets);
    }


    public SummaryReport getLostSumReport()
    {
        return new SummaryReport(allLostTickets, true);
    }


    //Formats the checkInTime to an int
    public int generateEntryHour() {
        int hour = randBetween(7, 12);
        //int minutes = randBetween(0, 59);

        return hour;

    }

    //Formats the checkOutTime to an int
    public int generateExitHour()
    {
        int hour = randBetween(13, 23);
        //int minutes = randBetween(0,59);

        return hour;
    }

    public static int randBetween(int start, int end)
    { return start + (int)Math.round(Math.random() * (end - start)); }


}
