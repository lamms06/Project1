package org;

import org.example.Gender;
import org.example.Person;
import org.junit.Test;

public class PersonTest {

    @Test
    public void testPerson() throws Exception {
        Person p = new Person("Jan", 130);
        System.out.println(p.getGender());
        p.setGender(Gender.MALE);
        System.out.println(p.getGender());
        p.haveBirthday(); // person gets one year older
        System.out.println(p.getAge());
        System.out.println(Person.universalRights);
    }

}
