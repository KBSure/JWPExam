package examples.first.ticket;

public class BTSShow implements Gate{
    @Override
    public boolean isAppropriateTicket(Ticket ticket) {
        if("BTS SHOW TICKET".equals(ticket.getTicketName())){
            return true;
        }
        return false;
    }
}
