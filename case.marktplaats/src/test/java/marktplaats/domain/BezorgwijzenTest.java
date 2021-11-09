package marktplaats.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BezorgwijzenTest {


    @Test
    void testGetBezorgwijzen() {
        Bezorgwijzen a = new Bezorgwijzen(true, true, true, true);
        Bezorgwijzen b = new Bezorgwijzen(true, true, true, false);
        Bezorgwijzen c = new Bezorgwijzen(true, true, false, false);
        Bezorgwijzen d = new Bezorgwijzen(true, false, false, false);
        Bezorgwijzen e = new Bezorgwijzen(false, false, false, false);
        assertEquals(a.getBezorgwijzen().toString(),"[Afhalen thuis, Afhalen magazijn, Versturen, Versturen Rembours]");
        assertEquals(b.getBezorgwijzen().toString(), "[Afhalen thuis, Afhalen magazijn, Versturen]");
        assertEquals(c.getBezorgwijzen().toString(), "[Afhalen thuis, Afhalen magazijn]");
        assertEquals(d.getBezorgwijzen().toString(), "[Afhalen thuis]");
        assertEquals(e.getBezorgwijzen().toString(), "[]");
    }
}