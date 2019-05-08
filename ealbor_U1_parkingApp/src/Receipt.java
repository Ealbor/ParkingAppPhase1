public class Receipt {

    private Ticket ticket;
    private final int MAX_CHARGE = 15;
    private final int MIN_CHARGE = 5;
    private boolean lostTicket = false;
    private final int LOST_TICKET_COST = 25;
    //Receipt(){}

    Receipt(Ticket currentTik)
    {
        ticket = currentTik;
    }

    Receipt(boolean lostTicket)
    {
        this.lostTicket = lostTicket;
    }

    //Getters/Setters


    public int getEntryHour() {
        return ticket.getCheckInTime();
    }

    public int getExitHour() {
        return ticket.getCheckOutTime();
    }

    public int getVehicleID()
    {
        return ticket != null ? ticket.getTicketId() : 0;
    }

    //simple subtraction of ticket time
    public int getHoursParked()
     {
         return ticket.getCheckOutTime() - ticket.getCheckInTime();
      }


    //if/else if logic incrementing cost
    public int getCost() {

        if (!lostTicket) {
            int hoursParked = getHoursParked();
            int cost = 0;

            if (hoursParked <= 3) {
                cost = MIN_CHARGE;
            } else if (hoursParked >= 4) {
                cost = MIN_CHARGE + (hoursParked - 3);
            }

            return cost <= 15 ? cost : MAX_CHARGE;
        } else {
                return LOST_TICKET_COST;
        }

    }
}
