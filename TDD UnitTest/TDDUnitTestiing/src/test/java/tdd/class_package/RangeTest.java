package tdd.class_package;

import org.junit.Test;
import static org.junit.Assert.*;

public class RangeTest {

    public RangeTest() {
    }

    @Test
    public void constructorTwoNine() throws InvalidRange {
        Range r = new Range("(2,9)");
        String expected = "(2,9)";
        String actual = r.toString();
        assertEquals(expected, actual);
    }

    @Test
    public void constructorTwelveThirtyTwo() throws InvalidRange {
        Range r = new Range("[12,32)");
        String expected = "[12,32)";
        String actual = r.toString();
        assertEquals(expected, actual);
    }

    @Test(expected = InvalidRange.class)
    public void constructorThreeTwoInvalid() throws InvalidRange {
        Range r = new Range("]3,2)");
    }

    @Test(expected = InvalidRange.class)
    public void constructorOneNineInvalid() throws InvalidRange {
        Range r = new Range("(1,9[");
    }

    @Test
    public void nineFifteenContainsTenFifteen() throws InvalidRange {
        Range r = new Range("[9,15]");
        assertTrue("El rango [9,15] debe contener los puntos 10 y 15", r.contains(10, 15));
    }

    @Test
    public void oneThreeContainsFiveSix() throws InvalidRange {
        Range r = new Range("(1,3)");
        assertFalse("El rango (1,3) debe contener los puntos 6 y 5", r.contains(5, 6));
    }
}
