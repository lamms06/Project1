package h5;

public class TafelsApp {

    public static void main(String[] args) {

        printTafelRecursive(1, 10);

    }

    public static void printTafel(int getal){
        int i;
        for (i = 1; i<=getal; i++){
            System.out.println(i + " x " + getal + " = " + (getal*i));
        }
    }

    public static void printTafelRecursive(int getal, int getal2){
        if (getal>10) return;
        System.out.println(getal + " x " + getal2 + " = " + (getal2*getal));
        printTafelRecursive(getal +1, getal2);
    }

}
