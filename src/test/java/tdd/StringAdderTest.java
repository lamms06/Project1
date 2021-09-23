package tdd;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringAdderTest {

    @Test
    public void testStringAdder_GetsNull_ReturnsZero() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int zero = adder.add(null);
        assertEquals(0,zero);
    }

    @Test
    public void testStringAdder_GestEmptyString_ReturnsZero() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int zero = adder.add("");
        assertEquals(0,zero);
    }

    @Test
    public void testStringAdder_GetsSinglenumber_ReturnsNumber() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int one = adder.add("1");
        assertEquals(1,one);
    }

    @Test
    public void testStringAdder_GetsMultipleNumbersWithCommas_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1,2,3");
        assertEquals(6,numbers);
    }

    @Test
    public void testStringAdder_GetsMultipleNumbersWithCommasAndNewlines_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2,3");
        assertEquals(6,numbers);
    }

    @Test
    public void testStringAdder_GetsMultipleNumbersMultipleDelimiters_ReturnsSum() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2;3");
        assertEquals(6,numbers);
    }

    @Test (expected = NegativesNotAllowedException.class)
    public void testStringAdder_NegativeNumbers_FiltersThose() throws NegativesNotAllowedException {
        StringAdder adder = new StringAdder();
        int numbers = adder.add("1\n2;3,-2,-3,-1");
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
