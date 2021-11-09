import JPA.Person;
import JPA.PersonDAO;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import static org.mockito.ArgumentMatchers.isA;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonDAOTest {

    @Mock
    EntityManager em;
    @Mock
    EntityTransaction et;

    @InjectMocks
    PersonDAO dao = new PersonDAO(em);

    @Test
    public void testInsert(){
        // given
        when(em.getTransaction()).thenReturn(et);
        doNothing().when(et).begin();
        doNothing().when(et).commit();

        // when
        dao.insert(new Person());

        // then
        verify(em).persist(isA(Person.class));

        verify(em, atLeastOnce()).getTransaction();
        verify(et).begin();
        verify(et).commit();
    }

    @Test
    public void testFind(){

    }
}
