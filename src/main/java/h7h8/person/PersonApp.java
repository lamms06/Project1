package h7h8.person;

import h10.Android;

import java.util.Date;

public class PersonApp {

    public void start() {

        Person stan = new Person("Stan", 26);
        System.out.println(stan.greet());
        System.out.println(stan.hashCode());
        stan=null;
        System.gc();
        System.out.println("gc called "+new Date().getTime());

        Android nats = new Android();
        nats.charge(50);
        nats.charge(30);
        //nats.charge(50); // gaat niet door, energylevel komt anders boven 100.

        System.out.println(nats.greet());
    }

}
