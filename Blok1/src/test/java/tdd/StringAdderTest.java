package tdd;



import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class StringAdderTest {

    @Test
    public void testStringAdder_Null_ReturnsZero() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int zero = adder.add(null);
        assertEquals(0,zero);
    }

    @Test
    public void testStringAdder_EmptyString_ReturnsZero() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int zero = adder.add("");
        assertEquals(0,zero);
    }

    @Test
    public void testStringAdder_SingleNumber_ReturnsNumber() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int one = adder.add("1");
        assertEquals(1,one);
    }

    @Test
    public void testStringAdder_MultipleNumbersWithCommas_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1,2,3");
        assertEquals(6,numbers);
    }

    @Test
    public void testStringAdder_MultipleNumbersWithCommasAndNewlines_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2,3");
        assertEquals(6,numbers);
    }

    @Test
    public void testStringAdder_MultipleNumbersMultipleDelimiters_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2;3");
        assertEquals(6,numbers);
    }

    @Test
    public void testStringAdder_NegativeNumbers_FiltersThose() {
        StringAdder adder = new StringAdder();
        assertThrows(NegativesNotAllowedException.class, ()->adder.add("1\n2;3,-2,-3,-1"));
    }

    @Test
    public void testStringAdder_NumberOver1000_FiltersThose() throws NegativesNotAllowedException{
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1,2,3,1001");
    }

    @Test
    public void testStringAdder_MultipleDelimiters_FiltersThose() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2;;;;  3");
    }

}
