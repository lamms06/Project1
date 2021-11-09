package marktplaats.dao;

import marktplaats.App;
import marktplaats.domain.*;
import marktplaats.producers.AlternativeProducers;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;


@EnableAutoWeld
@AddPackages(App.class)
@AddBeanClasses(AlternativeProducers.class)
@EnableAlternatives(AlternativeProducers.class)
public class DienstDaoTest {

    public Dienst dienst;
    public Dienst dienst2;

    @Inject
    public DienstDao target;

    @BeforeEach
    public void setup() {
        dienst = new Dienst("TaxiService Stan",
                50.00, DienstCategorie.VERVOER,
                new Betaalwijzen(true, true, true));
        dienst2 = new Dienst("Dummy Dienst",
                50.00, DienstCategorie.VERVOER,
                new Betaalwijzen(true, true, true));
    }

    @Test
    void testInsert_findAll() {
        target.insert(dienst);
        List<Dienst> diensten = target.findAll();
        assertThat(diensten).allMatch(p -> p.getId() != 0);
    }

    @Test
    void testInsertMultiple(){
        List<Dienst> list = new ArrayList<>();
        list.add(dienst);
        list.add(dienst2);
        target.addMultipleDienst(list);
        list=target.findAll();
        assertThat(list).allMatch(p -> p.getId() != 0);
    }

    @Test
    void testFindByName(){
        target.insert(dienst);
        List<Dienst> diensten = target.findByName("Stan");
        assertThat(diensten).allMatch(p -> p.getId() != 0);
        assertEquals(diensten.get(0).getName(), "TaxiService Stan");
    }

    @Test
    void testSelectProduct(){
        target.insert(dienst);
        assertEquals(target.selectProduct(2).toString(),"Id: 2, Name: TaxiService Stan, Categorie: VERVOER, Price: 50.0");
    }
}