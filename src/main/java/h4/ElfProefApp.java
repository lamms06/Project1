package h4;

public class ElfProefApp {

    public static int[] multipliers = {9, 8, 7, 6, 5, 4, 3, 2, 1};

    public static void main(String[] args) {


    }

    public int[] convertNumbersToArray(int number) {
        String stringValue = Integer.toString(number);
        int[] numberArray = new int[stringValue.length()];
        for (int i = 0; i < stringValue.length(); i++) {
            numberArray[i] = stringValue.charAt(i) - '0';
        }
        return numberArray;
    }

    public boolean isElfProef(int[] invoer) {
        int som = 0;
        for (int i = 0; i < invoer.length; i++) {
            som = som + (invoer[i] * multipliers[i]);
        }
        System.out.println(som);
        return (som % 11 == 0);
    }

    public void run(){
        int[] numbers = convertNumbersToArray(123456788);

        if (isElfProef(numbers)) {
            System.out.println("Elfproef gelukt!");
        } else {
            System.out.println("Elfproef Mislukt...");
            //Throw new IllegalArgumentException("Elfproef Mislukt..");
        }
    }


}
