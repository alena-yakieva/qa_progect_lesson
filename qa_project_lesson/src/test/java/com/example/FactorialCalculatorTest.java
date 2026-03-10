package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {

    @Test
    void testCalculateFactorial_Zero() {
        assertEquals(1L, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    void testCalculateFactorial_One() {
        assertEquals(1L, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    void testCalculateFactorial_SmallNumbers() {
        assertEquals(2L, FactorialCalculator.calculateFactorial(2));
        assertEquals(6L, FactorialCalculator.calculateFactorial(3));
        assertEquals(24L, FactorialCalculator.calculateFactorial(4));
        assertEquals(120L, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    void testCalculateFactorial_MediumNumbers() {
        assertEquals(3628800L, FactorialCalculator.calculateFactorial(10));
        assertEquals(479001600L, FactorialCalculator.calculateFactorial(12));
    }

    @Test
    void testCalculateFactorial_LargeNumber_WithinLongRange() {
        assertEquals(2432902008176640000L, FactorialCalculator.calculateFactorial(20));
    }

    @Test
    void testCalculateFactorial_NegativeNumber_ThrowsException() {
        IllegalArgumentException exception = assertThrows(
            IllegalArgumentException.class,
            () -> FactorialCalculator.calculateFactorial(-1)
        );
        assertEquals("Факториал отрицательного числа не существует.", exception.getMessage());
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-5));
        assertThrows(IllegalArgumentException.class, () -> FactorialCalculator.calculateFactorial(-100));
    }

    @Test
    void testCalculateFactorial_EdgeCases() {
        assertEquals(1L, FactorialCalculator.calculateFactorial(0)); 
        assertEquals(1L, FactorialCalculator.calculateFactorial(1)); 
    }
}
<<<<<<< HEAD

=======
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
