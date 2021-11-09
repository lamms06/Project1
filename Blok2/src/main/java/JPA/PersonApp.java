package JPA;

import org.jboss.weld.environment.se.Weld;
import org.jboss.weld.environment.se.WeldContainer;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.ArrayList;
import java.util.List;

@Singleton
public class PersonApp {

//    2. Unittest bouwen voor je Dao.
//    3. Integrationtest bouwen voor je Dao.


    @Inject
    PersonDAO persondao;

    @Inject
    PersonService jpaservice;

    public static void main(String[] args){
        Weld weld = new Weld();
        WeldContainer weldContainer = weld.initialize(); // de engine/container

        PersonApp app = weldContainer.select(PersonApp.class).get(); // vanaf hier kan ik in App en zijn dependencies (dao) @Inject gebruiken.
        app.start();
    }

    public void start(){
        jpaservice.addPerson("Lammers", "Stan");
        jpaservice.addPerson("Janssens", "Bram");
        persondao.insert(new Person("Stan2", "lammers2"));
        List<Person> personList = new ArrayList<>();
        personList.add(new Person("Stan", "Lammers"));
        personList.add(new Person("Bram", "Janssens"));
        jpaservice.addMultiplePerson(personList);
    }

}
