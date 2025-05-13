package UnitTest;

import static org.junit.Assert.*;
import org.junit.Test;

public class DivisorCounterTests {

    DivisorCounter divisorCounter = new DivisorCounter();

    @Test
    public void testValidDivisorCount() {
        assertEquals(2, divisorCounter.getValidDivisorCount(5));
    }

    @Test
    public void testNegativeAndZeroInput() {
        assertEquals(0, divisorCounter.getValidDivisorCount(0));
        assertEquals(0, divisorCounter.getValidDivisorCount(-10));
    }

    @Test
    public void testBoundaryCase() {
        assertEquals(0, divisorCounter.getValidDivisorCount(1));
    }
}
