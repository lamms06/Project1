package chainstore;

public class RegularCard extends Card{

    public RegularCard(){
        super();
    }

    public RegularCard(int cardId, int credit, String name){
        super(cardId,credit,name);
    }

    public boolean pay(int x){
        if(x<=this.credit){
            this.credit -=x;
            return true;
        }
        return false;
    }

    public int getId(){
        return this.cardId;
    }
}
