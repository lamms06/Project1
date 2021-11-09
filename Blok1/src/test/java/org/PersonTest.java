package org;

import h7h8.person.Gender;
import h7h8.person.Person;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class PersonTest {

    @Test
    public void testHaveBirthday_CorrectAge_Completes() {
        Person person = new Person("Stan",26);
        person.haveBirthday();
        assertEquals(person.getAge(), 27);
    }

    @Test
    public void testHaveBirthday_TooOld_ThrowsException() {
        Person person = new Person("Stan",130);
        assertThrows(Exception.class,()-> person.haveBirthday());
    }

    @Test
    public void testToString(){
        Person person = new Person("Stan", 26);
        person.setGender(Gender.MALE);
        assertEquals(person.toString(),"Stan 26 is MALE");
    }
    @Disabled
    @Test
    public void testHashCode_DifferentAttributes_DifferentHash(){
        Person person = new Person("Stan", 26);
        person.setGender(Gender.MALE);
        Person person2 = new Person("NietStan", 26);
        person2.setGender(Gender.MALE);
        assertEquals(person.hashCode(),-1637095914);
        assertEquals(person2.hashCode(),-519633743);
    }
    @Disabled
    @Test
    public void testHashCode_SameAttributes_SameHash(){
        Person person = new Person("Stan", 26);
        person.setGender(Gender.MALE);
        Person person2 = new Person("Stan", 26);
        person2.setGender(Gender.MALE);
        assertEquals(person.hashCode(),-1368688537);
        assertEquals(person2.hashCode(),-1368688537);
    }
}
