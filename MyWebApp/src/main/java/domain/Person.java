package domain;

public class Person {

    String firstname;
    String lastname;

    public Person(String firstname, String lastname){
        this.firstname = firstname;
        this.lastname = lastname;
    }

    @Override
    public String toString(){
        return firstname + " " + lastname;
    }

}
