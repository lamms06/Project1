package tdd2;

/*
1. Implementeer de class TrajectPrijsService met de methode getTrajectPrijs.
        2. Maak een test waarbij je interfaces voor 1 en 2 aanmaakt (implementatie is niet nodig).
        a. Mock deze types vervolgens.
        b. Maak de mocks beschikbaar voor de TrajectPrijsService instantie.
        c. Gebruik als testdata een traject dat je goed kent. (Bijv. location1="Amsterdam"
        location2="Utrecht").
        d. Programmeer de mocks zodanig dat er een trajectPrijs wordt teruggegeven die
        overeenkomt met het NS tarief.
        3. Maak een 2e test waarin een van de locaties een niet bestaande plaats is. De
        getTrajectEenheden gooit dan een InvalidLocationException. Vang de exception netjes af en geef
        de exception door.
*/

public class TrajectPrijsService {

    TrajectNaarTrajectEenhedenservice eenhedenservice;
    TrajectEenhedenNaarPrijsService prijsservice;

    public int getTrajectPrijs(String from, String to){
        int eenheden = eenhedenservice.getTrajectEenheden(from,to);
        int prijs = prijsservice.getPriceTrajectEenheden(eenheden);
        return prijs;
    }
}
