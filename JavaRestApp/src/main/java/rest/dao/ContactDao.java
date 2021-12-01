package rest.dao;

import rest.domain.Contact;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

import static javax.ejb.TransactionAttributeType.REQUIRED;

// @ApplicationScoped // Managed CDI bean, dus geen super powers
@Stateless //            Managed Enterprise Java Bean (EJB): hij krijgt super powers (zoals transaction capabilities).
//                       Stateless: de container maakt bij elk request een nieuwe instance;
//                       de class kan dus ook beter geen data-fields bevatten (dat heeft geen zin)!
public class ContactDao {

    // STATE: doesn't make sense in Stateless EJB.
    // private String name;

    @PersistenceContext // Container managed EntityManager, not via @Inject
    private EntityManager em; // container, geef mij een EntityManager

    // BEHAVIOUR:

    public List<Contact> getContacts() {
        return em.createNamedQuery("Contact.findAll", Contact.class)
                .getResultList();
    }

    public List<Contact> getContacts(String q) {
        return q == null ?
                em.createNamedQuery("Contact.findAll", Contact.class)
                        .getResultList() :
                em.createNamedQuery("Contact.findByQ", Contact.class)
                        .setParameter("q", "%" + q + "%")
                        .getResultList();
    }

    public Optional<Contact> getContact(Long id) {
        return Optional.ofNullable(em.find(Contact.class, id));
    }

    @TransactionAttribute(REQUIRED)  // = default; whole annotation can be omitted when choosing REQUIRED.
    //                                  Deze methode wordt in een databasetransactie op de server uitgevoerd.
    //                                  Als er al een transactie loopt, gebruikt de server die, anders maakt hij een nieuwe transactie aan.
    public Contact add(Contact c) {
        // no em.gettransation.begin/commit/rollback: is managed by (EJB) container at the server
        em.persist(c);
        return c;
    }

/*    public void remove(Long id) {
        getContact(id).ifPresentOrElse(em::remove, throwBadRequest(id));
    }*/


    public Contact update(Long id, Contact updatedContact) {
        updatedContact.setId(id);
        return em.merge(updatedContact);
    }

}

/*
@Singleton
public class ContactDao {

    private final Contact.ContactBuilder cb = Contact.builder();

    private final List<Contact> contacts = new ArrayList<>(List.of(
            cb.firstName("Bram").surname("Janssens").email("s.a.janssens@gmail.com").id(1L).build(),
            cb.firstName("Joop").surname("Janssens").email("j.janssens@gmail.com").id(2L).build(),
            cb.firstName("Mieke").surname("Janssens").email("m.janssens@gmail.com").id(3L).build()
    ));

    public List<Contact> getContacts() {
        return contacts;
    }

    public Optional<Contact> getContact(long id) {
        return contacts.stream() // 1) create a stream
                .filter(c -> c.getId() == id) // 2) bewerk de elementen in de stream
                .findAny();          // 3) reduce the stream
    }

    public List<Contact> getContacts(String q) {
        List<Contact> filteredlist = new ArrayList<>();
        for (Contact c : contacts) {
            if (c.toString().contains(q)) {
                filteredlist.add(c);
            }
        }
        return filteredlist;
    }
}*/
