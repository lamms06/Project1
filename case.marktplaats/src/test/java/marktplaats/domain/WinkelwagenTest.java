package marktplaats.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WinkelwagenTest {

    public Winkelwagen wagen;
    public Artikel artikel;
    public Artikel artikel2;

    @BeforeEach
    public void setup(){
        wagen = new Winkelwagen();
        artikel = new Artikel("Oude Herenfiets", 100.0,
                ArtikelCategorie.HOBBY,
                new Bezorgwijzen(true, true, true, false),
                new Betaalwijzen(true, true, true));
        wagen.addProductToCart(artikel);
        artikel2 = new Artikel("Dummy artikel", 100.0,
                ArtikelCategorie.HOBBY,
                new Bezorgwijzen(true, true, true, false),
                new Betaalwijzen(true, true, true));
    }

    @Test
    public void testAddProductToCart() {
        wagen.addProductToCart(artikel2);
        assertEquals(wagen.getProducten().size(), 2);
    }

    @Test
    public void testGetProducten(){
        assertEquals(wagen.getProducten().toString(), "[Id: null, Name: Oude Herenfiets, Categorie: HOBBY, Price: 100.0]");
    }

    @Test
    public void testRemoveAllFromCart(){
        wagen.removeAllFromCart();
        assertEquals(wagen.getProducten().size(), 0);
    }
}
