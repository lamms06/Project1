package marktplaats.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "bezorgwijzen")
public class Bezorgwijzen {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "afhalen_thuis")
    public boolean afhalenThuis = false;

    @Column(name = "afhalen_magazijn")
    public boolean afhalenMagazijn = false;

    @Column(name = "versturen")
    public boolean versturen = false;

    @Column(name = "versturen_rembours")
    public boolean versturenRembours = false;


    public Bezorgwijzen(boolean afhalenThuis, boolean afhalenMagazijn, boolean versturen, boolean versturenRembours) {
        this.afhalenThuis = afhalenThuis;
        this.afhalenMagazijn = afhalenMagazijn;
        this.versturen = versturen;
        this.versturenRembours = versturenRembours;
    }

    public List<String> getBezorgwijzen() {
        List<String> bezorgwijzenLijst = new ArrayList<>();
        if (afhalenThuis) {
            bezorgwijzenLijst.add("Afhalen thuis");
        }
        if (afhalenMagazijn) {
            bezorgwijzenLijst.add("Afhalen magazijn");
        }
        if (versturen) {
            bezorgwijzenLijst.add("Versturen");
        }
        if (versturenRembours) {
            bezorgwijzenLijst.add("Versturen Rembours");
        }
        return bezorgwijzenLijst;
    }
}
