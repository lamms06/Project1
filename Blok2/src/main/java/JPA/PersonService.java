package JPA;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import java.util.List;

public class PersonService {

    @Inject
    PersonDAO persondao;

    private EntityManager em;

    public void addPerson(String fname, String lname){
        Person p = new Person(fname, lname);
        persondao.insert(p);
    }

    public void addMultiplePerson(List<Person> personList){
        for(Person p:personList){
            persondao.insert(p);
        }
    }
}
