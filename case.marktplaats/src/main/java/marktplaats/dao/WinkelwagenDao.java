package marktplaats.dao;

import marktplaats.domain.Artikel;
import marktplaats.domain.Winkelwagen;
import marktplaats.utils.Util;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

public class WinkelwagenDao {

    private final EntityManager em;

    @Inject
    public WinkelwagenDao(EntityManager em) { // DIY dependency injection
        this.em = em;
    }

    @Inject
    ArtikelDao artikelDao;

    @Inject
    DienstDao dienstDao;

    @Inject
    Util utils;

    public void addArtikelToNewCart(long id) {
        em.getTransaction().begin();
        Winkelwagen wagen = new Winkelwagen();
        wagen.setTimestamp(new Timestamp(System.currentTimeMillis()));
        em.persist(wagen);
        Artikel artikel = em.find(Artikel.class, id);
        wagen.addProductToCart(artikel);
        artikel.setInWinkelwagen(true);
        em.merge(wagen);
        em.getTransaction().commit();
    }

    public void addArtikelToExistingCart(long productid, long cartid) {
        em.getTransaction().begin();
        Winkelwagen wagen = em.find(Winkelwagen.class, cartid);
        Artikel x = em.find(Artikel.class, productid);
        wagen.addProductToCart(x);
        wagen.setTimestamp(new Timestamp(System.currentTimeMillis()));
        x.setInWinkelwagen(true);
        em.merge(wagen);
        em.getTransaction().commit();
    }

    public List<Artikel> checkWinkelwagen(long id) {
        Winkelwagen wagen = em.find(Winkelwagen.class, id);
        System.out.println(wagen.producten);
        return wagen.producten;
    }

    public void removeCartKeepArticles(long cartid) {
        em.getTransaction().begin();
        Winkelwagen wagen = em.find(Winkelwagen.class, cartid);
        List<Artikel> producten = wagen.getProducten();
        for (Artikel a : producten) {
            a.setInWinkelwagen(false);
            em.merge(a);
        }
        wagen.removeAllFromCart();
        em.remove(wagen);
        em.getTransaction().commit();
    }

    public void removeCartRemoveArticles(long cartid) {
        em.getTransaction().begin();
        Winkelwagen wagen = em.find(Winkelwagen.class, cartid);
        List<Artikel> producten = wagen.getProducten();
        for (Artikel a : producten) {
            em.remove(a);
        }
        em.remove(wagen);
        em.getTransaction().commit();
    }

    public void removeProductFromCart(long productid, long cartid) {
        em.getTransaction().begin();
        Winkelwagen wagen = em.find(Winkelwagen.class, cartid);
        List<Artikel> producten = wagen.getProducten();
        producten.removeIf(artikel -> artikel.getId().equals(productid));
        Artikel a = em.find(Artikel.class, productid);
        a.setInWinkelwagen(false);
        em.merge(a);
        em.merge(wagen);
        em.getTransaction().commit();
    }

    public void validateWinkelwagens() {
        TypedQuery<Winkelwagen> query = em.createQuery("select w from Winkelwagen w ", Winkelwagen.class);
        List<Winkelwagen> wagens = query.getResultList();
        for (Winkelwagen wagen : wagens) {
            long difference = utils.checkDiff(wagen.getTimestamp(), new Timestamp(System.currentTimeMillis()));
            if (difference >= (60 * 60 * 1000)) {
                System.out.println("wagen verwijderen: " + wagen.getId());
                removeCartKeepArticles(wagen.getId());
            } else {
                System.out.println("wagen niet verwijderd: " + wagen.getId());
            }
        }
    }
}
