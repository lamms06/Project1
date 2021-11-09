package JPA;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data  @Builder @NoArgsConstructor @AllArgsConstructor // lombok
@Entity
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String fName;
    private String lName;

    public Person(String fname, String lname){
        this.fName = fname;
        this.lName = lname;
    }

    public Person(EntityManager em) {
    }

    public int getId() {
        return id;
    }

    public String getFirstname() {
        return fName;
    }

    public String getLastName() {
        return lName;
    }
}
