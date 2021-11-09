package marktplaats.dao;
import marktplaats.domain.Dienst;

import javax.inject.Inject;
import javax.persistence.*;
import java.util.List;

public class DienstDao {

    private final EntityManager em;

    @Inject
    public DienstDao(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    /* dienst in de database toevoegen / utility*/
    public void insert(Dienst dienst) {
        em.getTransaction().begin();
        em.merge(dienst);
        em.getTransaction().commit();
    }

    /* meerdere diensten in de database toevoegen / utility*/
    public void addMultipleDienst(List<Dienst> dienstList) {
        for (Dienst d : dienstList) {
            insert(d);
        }
    }

    /* producten weergeven / lijst van producten*/
    public List<Dienst> findAll() {
        TypedQuery<Dienst> query = em.createQuery("select d from Dienst d", Dienst.class);
        return query.getResultList();
    }

    /* zoeken op naam / simpel zoeken */
    public List<Dienst> findByName(String naam) {
        String parameter = "'%" + naam + "%'";
        TypedQuery<Dienst> query = em.createQuery("select d from Dienst d WHERE name LIKE " + parameter, Dienst.class);
        return query.getResultList();
    }

    /* dienst (gedetailleerd) weergeven */
    public Dienst selectProduct(long id) {
        TypedQuery<Dienst> query = em.createQuery("select d from Dienst d WHERE id = " + id, Dienst.class);
        return query.getSingleResult();
    }

}
