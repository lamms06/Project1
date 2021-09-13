package org.example;

import org.example.Gender;

import static org.example.Gender.UNKNOWN;

public class Person {

    private String name;
    private int age;
    private Gender gender;
    public static final String universalRights = "All humans are created equal.";
    public static final int MAX_AGE = 130;


    public Person(String name, int age){
        this.name = name;
        this.age = age;
        this.gender = UNKNOWN;
    }

    public void haveBirthday() throws Exception {
        int age = getAge();
        if(getAge()>=MAX_AGE){
            throw new Exception("Person Died");
        } else {
            setAge(getAge() + 1);
        }
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setGender(Gender gender){
        this.gender = gender;
    }
    public Gender getGender(){
        return gender;
    }

    public void setAge(int age) {
        this.age = age;
    }

}
