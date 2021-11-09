package tdd2;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class TrajectPrijsServiceTest {

    @Mock
    TrajectNaarTrajectEenhedenservice eenhedenservice;

    @Mock
    TrajectEenhedenNaarPrijsService prijsservice;

    @InjectMocks
    TrajectPrijsService service;

    @Test
    public void testGetTrajectPrijs(){
        when(eenhedenservice.getTrajectEenheden("Arnhem", "Apeldoorn")).thenReturn(5);
        when(prijsservice.getPriceTrajectEenheden(5)).thenReturn(10);
        assertEquals(service.getTrajectPrijs("Arnhem", "Apeldoorn"),10);
    }

}
