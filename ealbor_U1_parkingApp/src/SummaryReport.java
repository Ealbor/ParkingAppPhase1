import java.util.ArrayList;
import java.util.Collection;

public class SummaryReport {

    private int checkinSum = 0;
    private int numOfCheckins = 0;
    private int numOfLostTickets = 0;
    private int grandTotal = 0;

    //Assume that this class is getting a collection


    SummaryReport(ArrayList<Ticket> theList)
    {

        for(Ticket i : theList)
        {
            Receipt rc = new Receipt(i);

            //gets the sum of Checked in/out tickets
            this.checkinSum += rc.getCost();

            grandTotal =+ checkinSum;
        }

        numOfCheckins = theList.size();
}


    SummaryReport(ArrayList<Ticket> theList, boolean lostTickets)
    {

        for(Ticket i : theList)
        {
            Receipt rc = new Receipt(true);

            //gets the sum of Checked in/out tickets
            this.checkinSum += rc.getCost();

            grandTotal =+ checkinSum;
        }

        numOfCheckins = theList.size();
    }


    public int getCheckinSum(){return checkinSum;}

    public int getNumOfCheckins(){return numOfCheckins;}

    public int getGrandTotal(){return grandTotal;}




}
