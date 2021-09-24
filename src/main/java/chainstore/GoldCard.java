package chainstore;

/*
a. Datamember
        A gold card has a data member discount (int). In the setter check if the discount is in
        the range 1..30. Throw an argument out of range excepƟon if an invalid discount is
        assigned.
        b. Constructor
        Create a constructor which can iniƟalize all the data members. Make use of the
        constructor of the base class.
        c. Implement the pay method. The discount should be taken into account.

*/

public class GoldCard extends Card {

    private int discount;


    public GoldCard(){
        super();
    }

    public GoldCard(int cardId, int credit, String name){
        super(cardId,credit,name);
    }

    public GoldCard(int cardId, int credit, String name, int discount){
        super(cardId, credit, name);
        this.discount = discount;
    }

    public GoldCard(int cardId, double credit, String name, String address, String city){
        super(cardId, credit, name, address, city);
    }

    public boolean pay(int x){
        credit -= (x * (1 - (double)discount / 100));
            return true;
    }


    public int getId(){
        return this.cardId;
    }


    public void setDiscount(int discount) throws ArgumentOutOfRangeException {
        if(discount<1 || discount>30) {
            throw new ArgumentOutOfRangeException("Discount out of Range.");
        }
        this.discount = discount;
    }

    public int getDiscount(){
        return discount;
    }

    @Override
    public String toString() {return (cardId + "     "+ name + "     " + credit+ "      " + discount);}
}
