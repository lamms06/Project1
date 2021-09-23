package chainstore;

/*1. Create a base class Card with the following members:
        (the class must at least contain the properƟes cardId, name and credit. The rest may be
        omitted)
        a. Datamembers:
        cardId (int, readonly)
        name (String)
        address (String) (might be omiƩed)
        city (String) (might be omiƩed)
        credit (double)
        b. Constructor
        Create a constructor which can iniƟalize all the data members.
        c. Abstract method
        Create an abstract method Pay which will be implemented in a deriving class
boolean pay(int amount). The return type is used to signal if the payment was
        successful.*/


public abstract class Card {

    int cardId;
    double credit;
    String name;
    String adress;
    String city;

    public Card(){
        //
    }

    public Card(int cardId,double credit, String name){
        this.cardId = cardId;
        this.credit = credit;
        this.name = name;
    }

    public Card(int cardId, double credit, String name, String adress, String city){
        this(cardId, credit, name);
        this.adress = adress;
        this.city = city;
    }

    public abstract boolean pay(int amount);

}
