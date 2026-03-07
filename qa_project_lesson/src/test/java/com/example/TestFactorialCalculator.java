package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestFactorialCalculator {

    @DataProvider(name = "factorial-data")
public Object[][] factorialDataProvider() {
    return new Object[][] {
        {0, 1L},
        {1, 1L},
        {2, 2L},
        {3, 6L},
        {4, 24L},
        {5, 120L},
        {6, 720L},
        {7, 5040L},
        {8, 40320L},
        {9, 362880L},
        {10, 3628800L},
        {15, 1307674368000L}
        };
}

    @Test(dataProvider = "factorial-data")
    public void testCalculateFactorial(int input, long expected) {
        long result = FactorialCalculator.calculateFactorial(input);
        Assert.assertEquals(result, expected,
            "Факториал числа " + input + " должен быть равен " + expected);
    }

    @Test
    public void testFactorialOfZero() {
        long result = FactorialCalculator.calculateFactorial(0);
        Assert.assertEquals(result, 1L, "0! должен быть равен 1");
    }

    @Test
    public void testFactorialOfOne() {
        long result = FactorialCalculator.calculateFactorial(1);
        Assert.assertEquals(result, 1L, "1! должен быть равен 1");
    }

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testNegativeNumberThrowsException() {
        FactorialCalculator.calculateFactorial(-1);
    }

    @Test
    public void testLargeNumberWithinLongRange() {
        // 20! = 2432902008176640000
        long result = FactorialCalculator.calculateFactorial(20);
        Assert.assertEquals(result, 2432902008176640000L,
            "20! должен вычисляться корректно");
    }

    @Test
    public void testFactorialOverflow() {
        long result21 = FactorialCalculator.calculateFactorial(21);
        long result20 = FactorialCalculator.calculateFactorial(20);

        Assert.assertTrue(result21 < 0 || result21 < result20,
            "Результат для 21! должен указывать на переполнение");

}
}
