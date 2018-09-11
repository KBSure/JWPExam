package examples.first.ticket;

public class TicketCheckTest {
    public static void main(String[] args) {
        Ticket f1 = new FakeArmy();
        BTSShow btss1 = new BTSShow();

        if(btss1.isAppropriateTicket(f1)){
            System.out.println("어서들어오세요");
        }else{
            System.out.println("제대로 된 표를 구해오세요!");
        }
    }
}
