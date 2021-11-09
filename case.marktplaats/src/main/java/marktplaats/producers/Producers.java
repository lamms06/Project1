package marktplaats.producers;

import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class Producers {

    @Produces // instantie aanmaken en aanmelden bij de DI container (Weld)
    public static EntityManager em() {
        // Application managed EntityManager
        return Persistence.createEntityManagerFactory("MySQLMarktplaats").createEntityManager();
    }

//    @Produces
//    public Logger logger(InjectionPoint ip){
//        return LoggerFactory.getLogger(ip.getMember().getDeclaringClass());
//    }

}