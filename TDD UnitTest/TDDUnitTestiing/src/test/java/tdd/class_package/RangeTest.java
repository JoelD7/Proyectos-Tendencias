package tdd.class_package;

import org.junit.Assert;
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

    @Test
    public void fourEightContainsNegThreeNine() throws InvalidRange {
        Range r = new Range("[4,8)");
        assertFalse(r.contains(-3, 9));
    }

    @Test
    public void tenThirteenContainsElevenTwelve() throws InvalidRange {
        Range r = new Range("(10,13]");
        assertTrue(r.contains(11, 12));
    }

    @Test
    public void threeEighteenDoesntContainNegOneZero() throws InvalidRange {
        Range r = new Range("(3,18)");
        assertTrue(r.doesNotContain(-1, 0));
    }

    @Test
    public void oneTwoDoesntContainZeroNine() throws InvalidRange {
        Range r = new Range("(1,2)");
        assertTrue(r.doesNotContain(0, 9));
    }

    @Test
    public void twentyFiveFiftyDoesntContainThirtyThirtyOne() throws InvalidRange {
        Range r = new Range("[25,50]");
        assertFalse(r.doesNotContain(30, 31));
    }

    @Test
    public void tenTwentyOneDoesntContainSixteenTwenty() throws InvalidRange {
        Range r = new Range("[10,21)");
        assertFalse(r.doesNotContain(16, 20));
    }

    @Test
    public void getAllPointsOneFive() throws InvalidRange {
        Range r = new Range("[1,5)");
        int[] expected = {1, 2, 3, 4};
        int[] actual = r.getAllPoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllPointsTwelveTwenty() throws InvalidRange {
        Range r = new Range("[12,20]");
        int[] expected = {12, 13, 14, 15, 16, 17, 18, 19, 20};
        int[] actual = r.getAllPoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllPointsTwoFour() throws InvalidRange {
        Range r = new Range("(2,4)");
        int[] expected = {3};
        int[] actual = r.getAllPoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void getAllPointsThreeEight() throws InvalidRange {
        Range r = new Range("(3,8]");
        int[] expected = {4, 5, 6, 7, 8};
        int[] actual = r.getAllPoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void containsRangeFiveToEight() throws InvalidRange {
        Range r = new Range("[3,10]");
        assertTrue(r.containsRange("(5,8)"));
    }

    @Test
    public void containsRangeFifteenToSixteen() throws InvalidRange {
        Range r = new Range("(10,19)");
        assertTrue(r.containsRange("[15,16]"));
    }

    @Test
    public void containsRangeSevenToThirteen() throws InvalidRange {
        Range r = new Range("[1,4)");
        assertFalse(r.containsRange("(7,13]"));
    }

    @Test
    public void containsRangeOneToEight() throws InvalidRange {
        Range r = new Range("(20,29)");
        assertFalse(r.containsRange("(1,8)"));
    }

    @Test
    public void doesntContainRangeTwelveToTwenty() throws InvalidRange {
        Range r = new Range("(4,9)");
        assertTrue(r.doesNotContain("(12,20]"));
    }

    @Test
    public void doesntContainRangeFifteenToTwenty() throws InvalidRange {
        Range r = new Range("[3,14)");
        assertTrue(r.doesNotContain("[15,20]"));
    }

    @Test
    public void doesntContainRangeSixteenToNineteen() throws InvalidRange {
        Range r = new Range("(15,21)");
        assertFalse(r.doesNotContain("[16,19]"));
    }

    @Test
    public void doesntContainRangeSevenToTwelve() throws InvalidRange {
        Range r = new Range("[4,20]");
        assertFalse(r.doesNotContain("(7,12]"));
    }

    @Test
    public void endpointsTwelveFifteen() throws InvalidRange {
        Range r = new Range("(12,15)");
        int[] expected = {13, 14};
        int[] actual = r.endpoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void endpointsFiveEighteen() throws InvalidRange {
        Range r = new Range("[5,19)");
        int[] expected = {5, 18};
        int[] actual = r.endpoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void endpointsTenThirty() throws InvalidRange {
        Range r = new Range("[10,30]");
        int[] expected = {10, 30};
        int[] actual = r.endpoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void endpointsFiveTen() throws InvalidRange {
        Range r = new Range("(4,10]");
        int[] expected = {5, 10};
        int[] actual = r.endpoints();
        assertArrayEquals(expected, actual);
    }

    @Test
    public void overlapsThreeSeven() throws InvalidRange {
        Range r = new Range("[2,9)");
        assertTrue(r.overlaps("[3,7]"));
    }

    @Test
    public void overlapsEightTwentyThree() throws InvalidRange {
        Range r = new Range("(5,18)");
        assertTrue(r.overlaps("(8,23]"));
    }

    @Test
    public void overlapsEightOneTwo() throws InvalidRange {
        Range r = new Range("[19,23)");
        assertFalse(r.overlaps("[1,2]"));
    }

    @Test
    public void overlapsEightOneThree() throws InvalidRange {
        Range r = new Range("(4,11]");
        assertFalse(r.overlaps("(1,3]"));
    }

    @Test
    public void doesntOverlapThreeSeven() throws InvalidRange {
        Range r = new Range("[19,23)");
        assertTrue(r.doesNotOverlaps("[1,2]"));
    }

    @Test
    public void doesntOverlapSixTwelve() throws InvalidRange {
        Range r = new Range("[2,5]");
        assertTrue(r.doesNotOverlaps("(6,12]"));
    }

    @Test
    public void doesntOverlapThirtyTwoThirtyThree() throws InvalidRange {
        Range r = new Range("(31,34)");
        assertFalse(r.doesNotOverlaps("[32,33]"));
    }

    @Test
    public void doesntOverlapSevenNine() throws InvalidRange {
        Range r = new Range("[6,10)");
        assertFalse(r.doesNotOverlaps("[7,9)"));
    }

    @Test
    public void equalsThirteenFourteen() throws InvalidRange {
        Range r = new Range("(12,15)");
        assertTrue(r.equals("[13,14]"));
    }

    @Test
    public void equalsZeroThree() throws InvalidRange {
        Range r = new Range("[1,4)");
        assertFalse(r.equals("(0,3)"));
    }

    @Test
    public void equalsTwelveEighteen() throws InvalidRange {
        Range r = new Range("(12,18]");
        assertFalse(r.equals("[12,18]"));
    }

    @Test
    public void equalsFifteenNineTeen() throws InvalidRange {
        Range r = new Range("[15,19]");
        assertFalse(r.equals("(15,19)"));
    }

    @Test
    public void notEqualsTwelveEighteen() throws InvalidRange {
        Range r = new Range("(12,18]");
        assertTrue(r.notEquals("[12,18]"));
    }

    @Test
    public void notEqualsTenFourteen() throws InvalidRange {
        Range r = new Range("(8,11)");
        assertTrue(r.notEquals("[10,14]"));
    }

    @Test
    public void notEqualsOneNine() throws InvalidRange {
        Range r = new Range("[1,10)");
        assertFalse(r.notEquals("[1,9]"));
    }

    @Test
    public void notEqualsNineTwentyTwo() throws InvalidRange {
        Range r = new Range("[10,21]");
        assertFalse(r.notEquals("(9,22)"));
    }
}
