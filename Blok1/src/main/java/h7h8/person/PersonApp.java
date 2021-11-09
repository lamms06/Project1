package h7h8.person;

import h12.FlauweWoordgrappen;

public class PersonApp {

    public void start() {

        Person stan = new Person("Stan", 26);

        /* test de greet en hashcode overridden methods:
            System.out.println(stan.greet());
            System.out.println(stan.hashCode());
        */

        /* test de System.gc:
            stan=null;
            System.gc();
            System.out.println("gc called "+new Date().getTime());
        */

        /* test de Android "nats"
            Android nats = new Android();
            nats.charge(50);
            nats.charge(30);
                //nats.charge(50); // gaat niet door, energylevel komt anders boven 100.
            System.out.println(nats.greet());
        */

        stan.addHistory("history deel 1");
        stan.addHistory("history deel twee");

        stan.printHistory();

        System.out.println("recordcount: "+stan.recordcount);
        Person stan2 = new Person("Stan2", 27);
        new FlauweWoordgrappen().process(stan2);
        System.out.println(stan2);
    }

}
