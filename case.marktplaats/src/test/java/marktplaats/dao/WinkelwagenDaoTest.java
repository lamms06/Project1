package marktplaats.dao;

import marktplaats.App;
import marktplaats.domain.*;
import marktplaats.producers.AlternativeProducers;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import javax.persistence.TypedQuery;
import java.sql.Timestamp;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableAutoWeld
@AddPackages(App.class)
@AddBeanClasses(AlternativeProducers.class)
@EnableAlternatives(AlternativeProducers.class)
public class WinkelwagenDaoTest {

    public Artikel artikel;
    public Artikel artikel2;
    public Winkelwagen wagen;

    @Inject
    public WinkelwagenDao target;

    @Inject
    public ArtikelDao artikelDao;

    @BeforeEach
    public void setup() {
        artikel = new Artikel("Oude Herenfiets", 100.0,
                ArtikelCategorie.HOBBY,
                new Bezorgwijzen(true, true, true, false),
                new Betaalwijzen(true, true, true));

        artikel2 = new Artikel("Dummy Artikel", 100.0,
                ArtikelCategorie.HOBBY,
                new Bezorgwijzen(true, true, true, false),
                new Betaalwijzen(true, true, true));
        artikel2.setId(10L);
        wagen = new Winkelwagen(15l);
    }

    @Test
    public void testAddArtikelToNewCart() {
        artikelDao.insert(artikel);
        target.addArtikelToNewCart(3);
        assertEquals(artikel.getInWinkelwagen(), false);
    }


    @Test
    public void testAddArtikelToExistingCart() {
        artikelDao.insert(artikel);
        target.addArtikelToNewCart(3);
        target.checkWinkelwagen(4);
        artikelDao.insert(artikel2);
        target.addArtikelToExistingCart(10, 4);
    }

    @Test
    public void testCheckWinkelwagen() {
        artikelDao.insert(artikel);
        target.addArtikelToNewCart(3);
        String x = target.checkWinkelwagen(4).toString();
        assertEquals(x, "[Id: 3, Name: Oude Herenfiets, Categorie: HOBBY, Price: 100.0]");
    }

}
/*
    public void removeCartKeepArticles(long cartid){

    public void removeCartRemoveArticles(long cartid){

    public void removeProductFromCart(long productid, long cartid){

    public void validateWinkelwagens(){

}
*/