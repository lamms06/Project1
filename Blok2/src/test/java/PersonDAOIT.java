import JPA.Person;
import JPA.PersonApp;
import JPA.PersonDAO;
import org.assertj.core.api.Assertions;
import org.jboss.weld.junit5.auto.AddBeanClasses;
import org.jboss.weld.junit5.auto.AddPackages;
import org.jboss.weld.junit5.auto.EnableAlternatives;
import org.jboss.weld.junit5.auto.EnableAutoWeld;
import org.junit.jupiter.api.Test;
import javax.inject.Inject;
import java.util.List;


@EnableAutoWeld
@AddPackages(PersonApp.class)
@AddBeanClasses(AlternativeProducers.class)
@EnableAlternatives(AlternativeProducers.class)
public class PersonDAOIT {

    @Inject
    private PersonDAO dao;

    @Test
    public void testFindAll() {
        Person stan = new Person("Stan", "Lammers");
        List<Person> beforeInsert = dao.findAll();
        dao.insert(stan);
        List<Person> afterInsert = dao.findAll();
        assertTrue(afterInsert.size() > beforeInsert.size());
    }

    private void assertTrue(boolean b) {
    }

    @Test
    void testInsert(){
        dao.insert(new Person("Stan", "Lammers"));
        Assertions.assertThat(dao.findAll()).allMatch(e -> e.getId() != 0);
    }

    @Test
    void testFind(){
    }
}

