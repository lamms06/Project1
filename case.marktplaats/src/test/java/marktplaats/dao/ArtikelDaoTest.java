package marktplaats.dao;

import marktplaats.App;
import marktplaats.dao.ArtikelDao;
import marktplaats.domain.Artikel;
import marktplaats.domain.ArtikelCategorie;
import marktplaats.domain.Betaalwijzen;
import marktplaats.domain.Bezorgwijzen;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import marktplaats.producers.AlternativeProducers;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

@EnableAutoWeld
@AddPackages(App.class)
@AddBeanClasses(AlternativeProducers.class)
@EnableAlternatives(AlternativeProducers.class)
public class ArtikelDaoTest {

    public Artikel artikel;
    public Artikel artikel2;

    @Inject
    public ArtikelDao target;

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
    }

    @Test
    void testInsert_findAll() {
        target.insert(artikel);
        List<Artikel> artikelen = target.findAll();
        assertThat(artikelen).allMatch(p -> p.getId() != 0);
    }

    @Test
    void testInsertMultiple(){
        List<Artikel> list = new ArrayList<>();
        list.add(artikel);
        list.add(artikel2);
        target.addMultipleArtikel(list);
        list=target.findAll();
        assertThat(list).allMatch(p -> p.getId() != 0);
    }

    @Test
    void testFindByName(){
        target.insert(artikel);
        List<Artikel> artikelen = target.findByName("Oude");
        assertThat(artikelen).allMatch(p -> p.getId() != 0);
        assertEquals(artikelen.get(0).getName(), "Oude Herenfiets");
    }

    @Test
    void testSelectProduct(){
        target.insert(artikel);
        assertEquals(target.selectProduct(3).toString(),"Id: 3, Name: Oude Herenfiets, Categorie: HOBBY, Price: 100.0");
    }
}
