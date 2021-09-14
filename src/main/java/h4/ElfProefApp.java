package h4;

public class ElfProefApp {


  public static void main(String[] args) {
    int [] multipliers = {9,8,7,6,5,4,3,2,1};
    int [] numbers = convertNumbersToArray(123456788);

    if (isElfProef(numbers, multipliers)){
      System.out.println("Elfproef gelukt!");
    }  else{
      System.out.println("Elfproef Mislukt...");
      //Throw new IllegalArgumentException("Elfproef Mislukt..");
    }
  }

  public static int[] convertNumbersToArray(int number) {
    String stringValue = Integer.toString(number);
    int[] numberArray = new int[stringValue.length()];
    for (int i = 0; i < stringValue.length(); i++) {
      numberArray[i] = stringValue.charAt(i) - '0';
    }
    return numberArray;
  }

  public static boolean isElfProef(int[] invoer, int[] vermenigvuldiging) {
    int som = 0;
    for (int i = 0; i < invoer.length; i++){
      som = som + (invoer[i]*vermenigvuldiging[i]);
    }
    System.out.println(som);
    return (som%11==0);
  }




}
