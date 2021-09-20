package h6;

import java.util.Arrays;

public class Exercise {

    public void start(){
        long[] input = {1,2,3,4};
        int multiplier = 5;
        //multiplyLong(input, multiplier);
        System.out.println(Arrays.toString(multiplyLong(input, multiplier)));
    }

   public void exerciseOne(){
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        System.out.println(copy[2]);
    }

    public void exerciseTwo(){
        long[] row = new long[4];
        row[2] = 3;
        long[] copy = row;
        copy[2]++;
        System.out.println(copy[3]);
    }


    public long[] multiplyLong(long[] input, int multiplier ){
        for (int i = 0; i < input.length; i++) {
            input[i] = input[i]*multiplier;
        }
        return input;
    }

}
