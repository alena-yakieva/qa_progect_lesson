package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NumberComparisonTest {
    @Test
    void testFirstNumberGreater() {
        String result = NumberComparison.compareNumbers(10, 5);
        assertEquals("10 больше 5", result);
    }

    void testFirstNumberLess() {
        String result = NumberComparison.compareNumbers(3, 5);
        assertEquals("3 меньше 5", result);
    }

    void testNumberEquals() {
        String result = NumberComparison.compareNumbers(-3, -5);
        assertEquals("-3 больше -5", result);
    }

    void testNegativeNumdersFirstLess() {
        String result = NumberComparison.compareNumbers(-10, -3);
        assertEquals("-10 меньше -3", result);
    }

    @Test
    void testMixedSignsFirstGreater() {
        String result = NumberComparison.compareNumbers(0, -1);
        assertEquals("0 больше -1", result);
    }

    @Test
    void testMixedSignsFirstLess() {
        String result = NumberComparison.compareNumbers(-5, 10);
        assertEquals("-5 меньше 10", result);
    }

    @Test
    void testZeroComparison() {
        String result1 = NumberComparison.compareNumbers(0, 0);
        assertEquals("0 равно 0", result1);

        String result2 = NumberComparison.compareNumbers(0, 5);
        assertEquals("0 меньше 5", result2);

        String result3 = NumberComparison.compareNumbers(-3, 0);
        assertEquals("-3 меньше 0", result3);
    }

    @Test
    void testLargeNumbers() {
        String result1 = NumberComparison.compareNumbers(1000000, 999999);
        assertEquals("1000000 больше 999999", result1);

        String result2 = NumberComparison.compareNumbers(Integer.MAX_VALUE, Integer.MIN_VALUE);
        assertEquals(Integer.MAX_VALUE + " больше " + Integer.MIN_VALUE, result2);
    }

    @Test
    void testBoundaryValues() {
        String result1 = NumberComparison.compareNumbers(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MIN_VALUE + " меньше " + Integer.MAX_VALUE, result1);

        String result2 = NumberComparison.compareNumbers(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertEquals(Integer.MAX_VALUE + " равно " + Integer.MAX_VALUE, result2);
    }
}
