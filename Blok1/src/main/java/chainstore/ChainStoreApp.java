package chainstore;

public class ChainStoreApp {

    public void start(){


        ChainStore store = new ChainStore();
        store.fillCustomers();
        store.printCustomers();

        Card test = store.findCustomer(1001);
        System.out.println(test.credit);
        test.pay(100);
        System.out.println(test.credit);
        System.out.println("gelukt");
    }
}
