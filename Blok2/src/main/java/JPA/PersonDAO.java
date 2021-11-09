package JPA;
import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

//- findAll (m.b.v. query met/zonder param, namedquery),
//- delete,
//- updateFirstname,
//- update

@Singleton
public class PersonDAO {

    private final EntityManager em;

    @Inject
    public PersonDAO(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    public Person find(int id) {
        return em.find(Person.class, id);
    }

    public void insert(Person person){
        em.getTransaction().begin();
        em.merge(person);
        em.getTransaction().commit();
    }

    public List<Person> findAll() {
        TypedQuery<Person> query = em.createQuery("select p from Person p", Person.class);
        return query.getResultList();
    }

    public void delete(Person person){
        em.getTransaction().begin();
        em.remove(person);
        em.getTransaction().commit();
    }

    public void updateFname(int id, String name){
        em.getTransaction().begin();
        Person p = find(id);
        p.setFName(name);
        em.merge(p);
        em.getTransaction().commit();
    }

    public void update(int id, String fName, String lName){
        em.getTransaction().begin();
        Person p = find(id);
        p.setFName(fName);
        p.setLName(lName);
        em.merge(p);
        em.getTransaction().commit();
    }

    public void insertOud(Person person){
        em.getTransaction().begin();
        em.createNativeQuery("INSERT INTO Person (id, fName, lName) VALUES (?,?,?)")
                .setParameter(1, person.getId())
                .setParameter(2,person.getFirstname())
                .setParameter(3,person.getLastName())
                .executeUpdate();
        em.getTransaction().commit();
    }

}
