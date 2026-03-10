package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparisonTest {

     @Test
    void testCompareNumbers_FirstGreater() {
        String result = NumberComparison.compareNumbers(10, 5);
        assertEquals("10 больше 5", result);
    }

    @Test
    void testCompareNumbers_FirstLess() {
        String result = NumberComparison.compareNumbers(3, 7);
        assertEquals("3 меньше 7", result);
    }

    @Test
    void testCompareNumbers_EqualNumbers() {
        String result = NumberComparison.compareNumbers(5, 5);
        assertEquals("5 равно 5", result);
    }

    @Test
    void testCompareNumbers_NegativeNumbers_FirstGreater() {
        String result = NumberComparison.compareNumbers(-3, -7);
        assertEquals("-3 больше -7", result);
    }

    @Test
    void testCompareNumbers_NegativeNumbers_FirstLess() {
        String result = NumberComparison.compareNumbers(-10, -5);
        assertEquals("-10 меньше -5", result);
    }

    @Test
    void testCompareNumbers_MixedSigns_PositiveGreater() {
        String result = NumberComparison.compareNumbers(5, -3);
        assertEquals("5 больше -3", result);
    }

    @Test
    void testCompareNumbers_MixedSigns_NegativeGreater() {
        String result = NumberComparison.compareNumbers(-5, 3);
        assertEquals("-5 меньше 3", result);
    }

    @Test
    void testCompareNumbers_ZeroAndPositive() {
        assertEquals("0 меньше 5", NumberComparison.compareNumbers(0, 5));
        assertEquals("5 больше 0", NumberComparison.compareNumbers(5, 0));
    }

    @Test
    void testCompareNumbers_ZeroAndNegative() {
        assertEquals("0 больше -5", NumberComparison.compareNumbers(0, -5));
        assertEquals("-5 меньше 0", NumberComparison.compareNumbers(-5, 0));
    }

    @Test
    void testCompareNumbers_ZeroEqualsZero() {
        assertEquals("0 равно 0", NumberComparison.compareNumbers(0, 0));
    }

    @Test
    void testCompareNumbers_LargeNumbers() {
        assertEquals("1000000 больше 500000", NumberComparison.compareNumbers(1_000_000, 500_000));
        assertEquals("999999 меньше 1000000", NumberComparison.compareNumbers(999_999, 1_000_000));
    }

    @Test
    void testCompareNumbers_MinMaxValues() {
        assertEquals(Integer.MAX_VALUE + " больше " + Integer.MIN_VALUE,
                   NumberComparison.compareNumbers(Integer.MAX_VALUE, Integer.MIN_VALUE));
        assertEquals(Integer.MIN_VALUE + " меньше " + (Integer.MIN_VALUE + 1),
                   NumberComparison.compareNumbers(Integer.MIN_VALUE, Integer.MIN_VALUE + 1));
    }
}
<<<<<<< HEAD

=======
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
