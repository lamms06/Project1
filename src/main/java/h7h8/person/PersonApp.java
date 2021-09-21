package h7h8.person;

import java.util.Date;

public class PersonApp {

    public void start() {

        Person stan = new Person("Stan", 26);
        System.out.println(stan.hashCode());
        stan=null;
        System.gc();
        System.out.println("gc called "+new Date().getTime());
    }

}
