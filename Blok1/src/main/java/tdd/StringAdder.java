package tdd;

import java.util.ArrayList;
import java.util.List;

public class StringAdder {

    int sum = 0;
    List<Integer> negatives = new ArrayList<>();

    public int add(String numbers) throws NegativesNotAllowedException {
        if(numbers == null) return 0;
        return processNumbers(numbers);
    }

    private int processNumbers(String numbers) throws NegativesNotAllowedException {
        String[] parts = getSeparateEntries(numbers);

        for (String part : parts) {
            int number = processValidNumber(part);
            sum += filterUnwantedNumbers(number);
        }
        checkForNegatives();
        return sum;
    }

    private String[] getSeparateEntries(String numbers) {
        return numbers.trim().split("[\\s,*;\n]");
    }

    private void checkForNegatives() throws NegativesNotAllowedException {
        if (!(negatives.isEmpty())){
            System.out.println(negatives);
            throw new NegativesNotAllowedException("Negatives not allowed: "+negatives);
        }
    }

    private int filterUnwantedNumbers(int number) {
        if (number <0) {
            negatives.add(number);
        } else if (number<1000) {
            return number;
        } return 0;
    }

    private int processValidNumber(String numbers) {
        try{
            return Integer.parseInt(numbers);
        } catch (NumberFormatException e){
            //throw new IllegalArgumentException("Dit is geen nummer: "+ numbers);
            return 0;
        }
    }
}
