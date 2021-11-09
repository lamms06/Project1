package marktplaats.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
//@Builder
//@NoArgsConstructor
@Entity
@Table(name = "winkelwagen")
public class Winkelwagen {

    public Winkelwagen(){
        producten = new ArrayList<>();
    }

    public Winkelwagen(long id){
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", updatable = false, nullable = false)
    protected Long id;

    @Column(name = "producten")
    @OneToMany(targetEntity = Artikel.class)
    public List<Artikel> producten;

    private Timestamp timestamp;

    public void setTimestamp(Timestamp timestamp){
        this.timestamp = timestamp;
    }

    public Timestamp getTimestamp(){
        return timestamp;
    }

    public void addProductToCart(Artikel product) {
        producten.add(product);
    }

    public List<Artikel> getProducten(){
        return producten;
    }

    public void removeAllFromCart(){
        producten.clear();
    }
}
