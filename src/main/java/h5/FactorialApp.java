package h5;

public class FactorialApp {

    public static void main(String[] args) {
        factorial(5,5);
    }

    private static void factorial(int getal, int n){
        if(n<=0) return;
        getal = getal*n;
        System.out.println(getal);
        factorial(getal, n-1);
    }
}
