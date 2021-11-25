package marktplaats.domain;

public class SearchObject {

    private String naam;
    private double prijs;
    private ProductSoort soort;
    private ArtikelCategorie categorie;

    public SearchObject() {
        //
    }

    public SearchObject(String naam) {
        this.naam = naam;
    }

    public SearchObject(String naam, double prijs) {
        this(naam);
        this.prijs = prijs;
    }

    public SearchObject(String naam, double prijs, ProductSoort soort) {
        this(naam, prijs);
        this.soort = soort;
    }

    public SearchObject(String naam, double prijs, ProductSoort soort, ArtikelCategorie categorie) {
        this(naam, prijs, soort);
        this.categorie = categorie;
    }

    public SearchObject(double prijs, ProductSoort soort) {
        this.prijs = prijs;
        this.soort = soort;
    }

    public String getNaam() {
        return naam;
    }

    public double getPrijs() {
        return prijs;
    }

    public ProductSoort getSoort() {
        return soort;
    }

    public void setSoort(ProductSoort soort) {
        this.soort = soort;
    }

    public ArtikelCategorie getCategorie() {
        return categorie;
    }
}
