package chainstore;

import java.util.ArrayList;
import java.util.List;

public class ChainStore {

    private List<Card> customers = new ArrayList<>();

    public ChainStore(){

    }

    public ChainStore(List<Card> customers){
        this.customers = customers;
    }

    public void printCustomers(){
        System.out.println("CardID   Name      Credit      Discount");
        for (Card customer : customers){
            System.out.println(customer);
        }
    }

    public void fillCustomers(){
        customers.add(new RegularCard(1001,1100,"Stan1"));
        customers.add(new RegularCard(1002,1200,"Stan2"));
        customers.add(new RegularCard(1003,1300,"Stan3"));
        customers.add(new RegularCard(1004,1400,"Stan4"));
        customers.add(new RegularCard(1005,1500,"Stan5"));
        customers.add(new RegularCard(1006,1600,"Stan6"));
        customers.add(new GoldCard(2001, 2100, "Stan7", 5));
        customers.add(new GoldCard(2002, 2200, "Stan8", 10));
        customers.add(new GoldCard(2003, 2300, "Stan9", 15));
    }

    public Card findCustomer(int customer) {

        for (Card card : customers) {
            if (card.getId() == customer) {
                return card;
            }
        }
        return null;
    }
}
