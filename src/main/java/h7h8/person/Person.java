package h7h8.person;

import h10.Human;

import java.util.Date;
import java.util.Objects;

public class Person extends Human {
    private String name;
    private int age;
    private Gender gender;

    public static final int numberOfPossibleGenders = Gender.values().length;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = Gender.UNKNOWN;
    }

    public Person(String name, int age, Gender gender){
        this(name,age);
        this.gender = gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public void haveBirthday() {
        if (this.age >= 130) throw new PersonDiedException();
        this.age++;
    }

    public Gender getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString(){
        String x;
        return (name+ " "+age+" is "+gender);
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof Person)){
            return false;
        }
        Person person = (Person)obj;
        return this.name.equals(person.name)
                && (this.age == person.age)
                && (this.gender == person.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, gender);
    }

    @Override
    protected void finalize()
    {
        System.out.println("finalize method called "+new Date().getTime());
    }

    @Override
    public String greet(){
        return "Hello, my name is "+name+". Nice to meet you!";
    }

}