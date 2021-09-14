package h5;

public class GreatestApp {

    public static void main(String[] args) {

        System.out.println(greatest("hoi","hoihoi"));

    }

    public static int greatest(int a, int b){
        return Math.max(a, b);
    }

    public static String greatest(String a, String b){
       if(a.length()>b.length()){
           return a;
       }
       return b;
    }
}
