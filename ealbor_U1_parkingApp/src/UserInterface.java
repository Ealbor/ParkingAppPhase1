import java.sql.Time;
import java.util.*;

/**
 * User Interface Layer
 * This class interacts with the Business/Logic Layer (TicketManager Class)
 *
 * */

public class UserInterface {
    //Scanner for UI
    Scanner keyboard = new Scanner(System.in);

    //accepted by some methods
    private TicketManager tikMan;


    UserInterface() {
        tikMan = new TicketManager();
    }


    //UI screen for closeGarage
    private void closeGarage(SummaryReport sr, SummaryReport lostsr) {
        System.out.println();
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Activity to Date\n\n");
        System.out.println("$" + sr.getCheckinSum() + " was collected from " +
                sr.getNumOfCheckins() + " Check Ins");
        System.out.println("$" + lostsr.getCheckinSum() + " was collected from " +
                 lostsr.getNumOfCheckins() + " Lost Tickets\n\n");
        System.out.println("$" + (sr.getGrandTotal() + lostsr.getGrandTotal()) + " was collected overall");
        System.exit(1);
    }


    //UI screen for checkoutScreen
    private void checkOutScreen(Receipt rc) {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle id " + rc.getVehicleID() + "\n");
        System.out.println(rc.getHoursParked() + " hours parked " + rc.getEntryHour() + "am - " + (rc.getExitHour()-12) + "pm\n");
        System.out.println("$" + rc.getCost() + "\n");
        System.out.println();   //Extra space on console;
    }


    //UI screen for
    private void lostTicketScreen(Receipt rc) {
        System.out.println("Best Value Parking Garage");
        System.out.println("=========================");
        System.out.println("Receipt for vehicle id " + rc.getVehicleID() + "\n");
        System.out.println("Lost Ticket");
        System.out.println("$" + rc.getCost()+ "\n");
        System.out.println();   //Extra space on console
    }


    //first UI screen
    public Boolean optionsSetOne() {
        String optionSelected = "";
        boolean valid = true;

        while (valid) {
            try {
                System.out.println("Best Value Parking Garage\n");
                System.out.println("=========================");
                System.out.println("1 - Check/In");
                System.out.println("3 - Close Garage");
                System.out.println("=>");
                optionSelected = keyboard.nextLine();

                if (Integer.parseInt(optionSelected) == 1) {
                    tikMan.checkIn();
                    System.out.println();
                    System.out.println();//extra space on console
                    break;
                } else if (Integer.parseInt(optionSelected) == 3) {
                    closeGarage(tikMan.getSumReport(), tikMan.getLostSumReport());
                    System.out.println();
                    System.out.println(); //Extra space on console
                    tikMan.saveTickets(false, false);
                    tikMan.saveTickets( true, true);
                    return true;
                } else {
                    valid = false;
                    System.out.println("Choose on of the two options!\n");
                }

            } catch (Exception e) {
                System.out.println("Be sure to choose one of the two options! \n");
                //providing some breathing space
                System.out.println();
            }
        }
        return  false;

}


    //2nd UI screen
    public void optionsSetTwo() {
        String optionSelected = "";
        boolean invalid = true;


        while (invalid) {
            try {
                System.out.println("Best Value Parking Garage\n");
                System.out.println("=========================");
                System.out.println("1 - Check/Out");
                System.out.println("2 - Lost Ticket");
                System.out.println("=>");
                optionSelected = keyboard.nextLine();

                if (Integer.parseInt(optionSelected) == 1) {
                    checkOutScreen(tikMan.checkOut());
                    System.out.println();
                    System.out.println(); //extra space on console
                    break;

                } else if (Integer.parseInt(optionSelected) == 2) {

                    lostTicketScreen(tikMan.checkOut(true));
                    System.out.println();
                    System.out.println(); //extra space on console.
                    break;
                } else {
                    System.out.println("Choose one of the two options!\n");
                }
            } catch (Exception e) {
                System.out.println("Be sure to choose one of the two options! \n");
                //providing some breathing space
                System.out.println();
            }
        }
    }

}
