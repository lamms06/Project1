package h10;

public class Android extends Human implements Chargable{

    private int energy;
    private static final int maxLevel = 100;

    @Override
    public String greet(){
        return "I'm only half human, but human stil... My energylevel is: " + energy;
    }

    public int charge(int amount){
        if (amount+energy <= maxLevel) energy = energy + amount;
        return energy;
    }
}
