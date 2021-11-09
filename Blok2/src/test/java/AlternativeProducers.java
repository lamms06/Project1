import javax.enterprise.inject.Alternative;
import javax.enterprise.inject.Produces;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

@Singleton
@Alternative
public class AlternativeProducers {

    public static EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("H2").createEntityManager();
    }

}
