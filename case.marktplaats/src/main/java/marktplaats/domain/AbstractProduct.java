package marktplaats.domain;

import lombok.Data;

import javax.persistence.*;

@Data
@MappedSuperclass
public abstract class AbstractProduct {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column
    public String name;
    public double price;

    public abstract String selectProduct();

    public abstract Long getId();

    // bezorgwijzen -> Artikel
    // private ? category;


    //private String omschrijving; // later object?
    //private ? betaalwijzen;

}
