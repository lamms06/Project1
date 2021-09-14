package h4;

import static h4.Seasons.*;

public class SeasonApp {
    public static void main(String[] args) {

        System.out.println(isWarmOrCold(SUMMER));
        System.out.println(isWarmOrCold(WINTER));

    }

    public static String isWarmOrCold(Seasons season){
        return season.label;
    }
}
