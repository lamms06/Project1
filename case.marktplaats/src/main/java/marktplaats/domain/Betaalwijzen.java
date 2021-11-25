package marktplaats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/* Enum ipv boolean*/

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "betaalwijzen")
public class Betaalwijzen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "creditcard")
    public boolean creditCard = false;

    @Column(name = "contant")
    public boolean contant = false;

    @Column(name = "ideal")
    public boolean ideal = false;

    public Betaalwijzen(boolean creditCard, boolean contant, boolean ideal) {
        this.creditCard = creditCard;
        this.contant = contant;
        this.ideal = ideal;
    }

    public List<String> getBetaalwijzen() {
        List<String> betaalwijzenLijst = new ArrayList<>();
        if (creditCard == true) {
            betaalwijzenLijst.add("CreditCard");
        }
        if (contant == true) {
            betaalwijzenLijst.add("Contant");
        }
        if (ideal == true) {
            betaalwijzenLijst.add("IDEAL");
        }
        return betaalwijzenLijst;
    }
}
