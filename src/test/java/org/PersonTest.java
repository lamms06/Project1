package org;

import org.example.Person;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PersonTest {

    @Test
    public void testHaveBirthday_CorrectAge_Completes() throws Exception {
       Person person = new Person("Stan",26);
       person.haveBirthday();
       assertEquals(person.getAge(), 27);
    }

    @Test(expected = Exception.class)
    public void testHaveBirthday_TooOld_ThrowsException() throws Exception {
        Person person = new Person("Stan",130);
        person.haveBirthday();
    }

}
