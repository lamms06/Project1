package marktplaats.domain;

import lombok.*;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "dienst")
public class Dienst extends AbstractProduct {

    @Basic
    @Enumerated(EnumType.STRING)
    public DienstCategorie categorie;

    @Basic
    @Enumerated(EnumType.STRING)
    public final ProductSoort soort = ProductSoort.DIENST;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "betaalwijzen_id", referencedColumnName = "id")
    public Betaalwijzen betaalwijzen;

    public Dienst(String name) {
        this.name = name;
    }

    public Dienst(String name, double price) {
        this(name);
        this.price = price;
    }

    public Dienst(String name, double price, DienstCategorie categorie) {
        this(name,price);
        this.categorie = categorie;
    }

    public Dienst(String name, double price, DienstCategorie categorie, Betaalwijzen betaalwijzen){
        this(name, price, categorie);
        this.betaalwijzen = betaalwijzen;
    }

    public Dienst(DienstCategorie categorie) {
        this.categorie = categorie;
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
                + soort);
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
