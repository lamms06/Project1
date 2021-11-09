package h12;

import h7h8.person.Person;

public class AnnotationApp {

    public static void main(String[] args) {
        Person bram = new Person();
        System.out.println(bram);
        new FlauweWoordgrappen().process(bram);
        System.out.println(bram);
    }

}
