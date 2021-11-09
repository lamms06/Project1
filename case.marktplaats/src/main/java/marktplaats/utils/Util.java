package marktplaats.utils;

import marktplaats.dao.ArtikelDao;
import marktplaats.dao.DienstDao;
import marktplaats.domain.*;

import javax.inject.Inject;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Util {

    @Inject
    ArtikelDao artikelDao;

    @Inject
    DienstDao dienstDao;

    public void print(String string) {
        System.out.println(string);
    }

    public void fillProducts() {
        List<Artikel> artikelen = new ArrayList<>();
        artikelen.add(new Artikel("Oude Herenfiets", 100.0, ArtikelCategorie.HOBBY, new Bezorgwijzen(true, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 1", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 2", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 3", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(true, false, false, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 4", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 5", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(true, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 6", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Harry Potter 7", 100.0, ArtikelCategorie.BOEKEN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Kleurpotloden", 100.0, ArtikelCategorie.HOBBY, new Bezorgwijzen(true, true, true, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Kleurboek", 100.0, ArtikelCategorie.HOBBY, new Bezorgwijzen(true, false, true, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Lego Kasteel", 100.0, ArtikelCategorie.HOBBY, new Bezorgwijzen(false, false, false, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Bestekset Zilver", 100.0, ArtikelCategorie.KEUKEN, new Bezorgwijzen(false, true, false, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Laptop Acer", 100.0, ArtikelCategorie.MULTIMEDIA, new Bezorgwijzen(false, true, true, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Beeldscherm 23inch", 100.0, ArtikelCategorie.MULTIMEDIA, new Bezorgwijzen(true, false, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Kerstboom 2020", 100.0, ArtikelCategorie.TUIN, new Bezorgwijzen(false, true, true, false), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Kamerplant levend", 100.0, ArtikelCategorie.TUIN, new Bezorgwijzen(true, true, true, true), new Betaalwijzen(true, true, true)));
        artikelen.add(new Artikel("Stan", 50.0, ArtikelCategorie.HOBBY, new Bezorgwijzen(true, true, false, false), new Betaalwijzen(true, true, true)));
        artikelDao.addMultipleArtikel(artikelen);

        List<Dienst> diensten = new ArrayList<>();
        diensten.add(new Dienst("TaxiService Stan", 50.00, DienstCategorie.VERVOER, new Betaalwijzen(true, true, true)));
        diensten.add(new Dienst("VervoersService Stan", 70.00, DienstCategorie.VERVOER, new Betaalwijzen(true, true, true)));
        diensten.add(new Dienst("Verhuisdienst Stan", 200.00, DienstCategorie.VERVOER, new Betaalwijzen(true, true, true)));
        diensten.add(new Dienst("Heitje voor karweitje", 10.00, DienstCategorie.OVERIGE_DIENSTEN, new Betaalwijzen(true, true, true)));
        diensten.add(new Dienst("Kookcursus", 75.00, DienstCategorie.HUISHOUDELIJK, new Betaalwijzen(true, true, true)));
        diensten.add(new Dienst("Computerhulp Stan", 30.00, DienstCategorie.COMPUTERHULP, new Betaalwijzen(true, true, true)));
        dienstDao.addMultipleDienst(diensten);
    }

    public long checkDiff(Timestamp timestamp, Timestamp currentTime) {
        long diff = currentTime.getTime() - timestamp.getTime();
        System.out.println(diff);
        return diff;
    }
}
