package marktplaats.domain;

import lombok.*;

import javax.persistence.*;

//@Data
@NoArgsConstructor
@Entity
@Table(name = "artikel")
public class Artikel extends AbstractProduct {

    @Column //?
    @Basic  //?
    @Enumerated(EnumType.STRING)
    public ArtikelCategorie categorie;

    @Column
    @Basic
    @Enumerated(EnumType.STRING)
    public final ProductSoort soort = ProductSoort.ARTIKEl;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "bezorgwijzen_id", referencedColumnName = "id")
    private Bezorgwijzen bezorgwijzen;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "betaalwijzen_id", referencedColumnName = "id")
    public Betaalwijzen betaalwijzen;

    private boolean inWinkelwagen;

    public Artikel(String name, double price){
        this.name = name;
        this.price = price;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie) {
        this(name, price);
        this.categorie = categorie;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie, Bezorgwijzen bezorgwijzen) {
        this(name, price, categorie);
        this.bezorgwijzen = bezorgwijzen;
    }

    public Artikel(String name, double price, ArtikelCategorie categorie,
                   Bezorgwijzen bezorgwijzen, Betaalwijzen betaalwijzen){
        this(name, price, categorie, bezorgwijzen);
        this.betaalwijzen = betaalwijzen;
    }

    public boolean getInWinkelwagen(){
        return inWinkelwagen;
    }

    public void setInWinkelwagen(boolean inwagen){
        inWinkelwagen = inwagen;
    }

    public Long getId(){
            return id;
    }
    public String selectProduct() {
        return ("Id: "
                + id + ", Name: "
                + name + ", Categorie: "
                + categorie + ", Price: "
                + price + ", Soort: "
                + soort + ", Bezorgwijzen: "
                + bezorgwijzen.getBezorgwijzen() + ", Betaalwijzen: "
                + betaalwijzen.getBetaalwijzen());
    }

    @Override
    public String toString() {
        return ("Id: "
                + id + ", Name: "
                + name + ", Categorie: "
                + categorie + ", Price: "
                + price);
    }

}



