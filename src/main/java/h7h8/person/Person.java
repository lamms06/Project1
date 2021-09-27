package h7h8.person;

/*
 Create the method public Human createSubHuman() in Person, which creates a Human-object using
an anonymous class, with the greeting "Sub is the best."
*/

import h10.Human;

import java.util.ArrayList;
import java.util.Date;
import java.util.Objects;

public class Person extends Human {
    private String name;
    private int age;
    private Gender gender;
    private HistoryRecord[] records;
    public int recordcount = 0;
    public static final int MAX_VALUE = 10;
    public static final int MAX_RECORDS=10;

    public static final int numberOfPossibleGenders = Gender.values().length;

    public Person(){}

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
        this.gender = Gender.UNKNOWN;
        this.records = new HistoryRecord[MAX_VALUE];
    }

    public Person(String name, int age, Gender gender){
        this(name,age);
        this.gender = gender;
    }

    private class HistoryRecord {
        private String description;

        public HistoryRecord(String description){
            this.description = description;
        }

        @Override
        public String toString(){
            return description;
        }
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

    public void addHistory(String descr){
        //if (recordcount == 9) recordcount = 0; //Voor als je oudere records wil kunnen overschrijven zodra MAX_RECORDS bereikt is.
        HistoryRecord record = new HistoryRecord(descr);
        records[recordcount]=record;
        recordcount +=1;
    }

    public void printHistory(){
        for (int i = 0; i < recordcount; i++) {
            System.out.println(records[i]);
        }
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