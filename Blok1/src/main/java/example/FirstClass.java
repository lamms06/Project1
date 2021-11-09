package example; // package name
public class FirstClass { // class name

    public static void main(String[] args){

        int getal = 2000000000;
        int getal2 = 2000000000;

        if(overflowCheck(getal, getal2)){
            System.out.println("int will overflow, converted int to long:");
            long result = (long)getal + (long)getal2;
            System.out.println("resultaat: " + result);
        }

    }


    public static boolean overflowCheck(int getal, int getal2){
        long eerste = getal;
        long tweede = getal2;
        if((eerste+tweede)>2147483647 || (eerste+tweede)<-2147483647){
            return true;
        }
        return false;
    }

}