package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestNumberComparison {

    @Test
    public void testNumberGreater() {
        String result = NumberComparison.compareNumbers(10, 5);
        Assert.assertEquals(result, "10 больше 5");
    }

    @Test
    public void testNumberLess() {
        String result = NumberComparison.compareNumbers(3, 4);
        Assert.assertEquals(result, "3 меньше 4");
    }

    @Test
    public void testEqualNumbers() {
        String result = NumberComparison.compareNumbers(5, 5);
        Assert.assertEquals(result, "5 равно 5");
    }

    @Test
    public void testNegativeNumbersFirstGreater() {
        String result = NumberComparison.compareNumbers(-1, -9);
        Assert.assertEquals(result, "-1 больше -9");
    }

    @Test
    public void testNegativeNumbersFirstLess() {
        String result = NumberComparison.compareNumbers(-8, -5);
        Assert.assertEquals(result, "-8 меньше -5");
    }

    @Test
    public void testMixedSignsFirstPositive() {
        String result = NumberComparison.compareNumbers(0, -9);
        Assert.assertEquals(result, "0 больше -9");
    }

    @Test
    public void testMixedSignsFirstNegative() {
        String result = NumberComparison.compareNumbers(-8, 5);
        Assert.assertEquals(result, "-8 меньше 5");
    }

    @Test
    public void testZeroComparison() {
        String result = NumberComparison.compareNumbers(0, 0);
        Assert.assertEquals(result, "0 равно 0");
    }

    @Test
     public void testLargeNumbers() {
        String result = NumberComparison.compareNumbers(1_000_000, 999_999);
        Assert.assertEquals(result, "1000000 больше 999999");
    }

    @Test
    public void testMinMaxValues() {
        String result = NumberComparison.compareNumbers(Integer.MAX_VALUE, Integer.MIN_VALUE);
        Assert.assertEquals(result, (Integer.MAX_VALUE + " больше " + Integer.MIN_VALUE));
    }
}