package marktplaats.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BetaalwijzenTest {

    @Test
    void testGetBetaalwijzen() {
        Betaalwijzen a = new Betaalwijzen(true, true, true);
        Betaalwijzen b = new Betaalwijzen(true, true, false);
        Betaalwijzen c = new Betaalwijzen(true, false, false);
        Betaalwijzen d = new Betaalwijzen(false, false, false);
        assertEquals(a.getBetaalwijzen().toString(),"[CreditCard, Contant, IDEAL]");
        assertEquals(b.getBetaalwijzen().toString(), "[CreditCard, Contant]");
        assertEquals(c.getBetaalwijzen().toString(), "[CreditCard]");
        assertEquals(d.getBetaalwijzen().toString(), "[]");
    }
}