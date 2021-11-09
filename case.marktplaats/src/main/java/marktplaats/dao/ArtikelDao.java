package marktplaats.dao;

import jdk.jfr.Category;
import marktplaats.domain.Artikel;
import marktplaats.domain.ArtikelCategorie;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;

@Singleton
public class ArtikelDao {

    private final EntityManager em;

    @Inject
    public ArtikelDao(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    /* artikel in de database toevoegen / utility*/
    public void insert(Artikel artikel) {
        em.getTransaction().begin();
        em.merge(artikel);
        em.getTransaction().commit();
    }

    /* meerdere artikelen in de database toevoegen / utility*/
    public void addMultipleArtikel(List<Artikel> artikelList) {
        for (Artikel a : artikelList) {
            insert(a);
        }
    }

    /* producten weergeven / lijst van producten*/
    public List<Artikel> findAll() {
        TypedQuery<Artikel> query = em.createQuery("select a from Artikel a where a.inWinkelwagen = false", Artikel.class);
        return query.getResultList();
    }

    /* zoeken op naam / simpel zoeken */
    public List<Artikel> findByName(String naam) {
        String parameter = "'%" + naam + "%'";
        TypedQuery<Artikel> query = em.createQuery("select a from Artikel a WHERE name LIKE " + parameter, Artikel.class);
        return query.getResultList();
    }

    /* artikel (gedetailleerd) weergeven */
    public Artikel selectProduct(long id) {
        TypedQuery<Artikel> query = em.createQuery("select a from Artikel a WHERE id = " + id, Artikel.class);
        return query.getSingleResult();
    }

    public List<Artikel> findByCategorie(ArtikelCategorie categorie){
        TypedQuery<Artikel> query = em.createQuery("SELECT a FROM Artikel a WHERE categorie = "+categorie, Artikel.class);
        return query.getResultList();
    }
}
