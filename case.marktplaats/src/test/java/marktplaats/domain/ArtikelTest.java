package marktplaats.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ArtikelTest {

    public static final String SELECTPRODUCT = "Id: null, Name: Oude Herenfiets, Categorie: HOBBY, Price: 100.0, Soort: ARTIKEl, Bezorgwijzen: [Afhalen thuis, Afhalen magazijn, Versturen], Betaalwijzen: [CreditCard, Contant, IDEAL]";
    public static final String TOSTRING = "Id: null, Name: Oude Herenfiets, Categorie: HOBBY, Price: 100.0";
    public Artikel artikel;

    @BeforeEach
    public void setup() {
        artikel = new Artikel("Oude Herenfiets", 100.0,
                ArtikelCategorie.HOBBY,
                new Bezorgwijzen(true, true, true, false),
                new Betaalwijzen(true, true, true));
    }

    @Test
    public void testSelectProduct() {
        assertEquals(artikel.selectProduct(), SELECTPRODUCT);
    }

    @Test
    public void testToString(){
        assertEquals(artikel.toString(), TOSTRING);
    }
}
