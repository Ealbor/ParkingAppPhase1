import java.util.InputMismatchException;
import java.util.Scanner;

public class Main{

    public static void main(String[] args)
    {


        //Open file
        //Push file to collection

        //Instantiate the ticketManager class
        UserInterface ui = new UserInterface();

        boolean garageClosed = false;
        while(!garageClosed) {
            //first UI
            garageClosed = ui.optionsSetOne();

            //Second UI
            ui.optionsSetTwo();
        }

    }
}




    //Steps


    /* CheckIn()
     * - Creates an initial ticket
     *
      * [Adds ticket to list]
     * -        Necessary?
     *          - I would say no. 2nd UI will either complete the Ticket objects properties,
     *              or it will assign it as lost.
     */


     /* CheckOut()
     * - ticket.setCheckedOut(sets other time property)
     *
     * - calculateCost(uses Ticket's time properties)
     * - generateReceipt(uses checkOutScreen UI)
     * - writeToFile(pushes arrayList to file)
     * - Closes file*/


     /* lostTicket()
     * - Ignores Ticket's checkedOutTime property
     * - sets Ticket object's boolean to true
     * - Tickets total property is set to $25 constant
     * - written to file.
     */


     /* closeGarage()
     * - takes open file and throws in to collection
     * - Collection iterated through
     * - checkedTickets tallied
     * - checkedLost tallied
     * - values plugged into the lostTicketScreen();
       */