package marktplaats.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DienstTest {

    public static final String SELECTPRODUCT = "Id: null, Name: TaxiService Stan, Categorie: VERVOER, Price: 50.0, Soort: DIENST";
    public static final String TOSTRING = "Id: null, Name: TaxiService Stan, Categorie: VERVOER, Price: 50.0";
    public Dienst dienst;

    @BeforeEach
    public void setup() {
        dienst = new Dienst("TaxiService Stan",
                50.00, DienstCategorie.VERVOER,
                new Betaalwijzen(true, true, true));
    }
    @Test
    void selectProduct() {
        assertEquals(dienst.selectProduct(), SELECTPRODUCT);
    }

    @Test
    void testToString() {
        assertEquals(dienst.toString(), TOSTRING);
    }
}