package com.example;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FactorialCalculatorTest {
    @Test
    void testFactorialOfZero() {
        assertEquals(1, FactorialCalculator.calculateFactorial(0));
    }

    @Test
    void testFactorialOfOne() {
        assertEquals(1, FactorialCalculator.calculateFactorial(1));
    }

    @Test
    void testFactorialOfPositiveNumber() {
        assertEquals(6, FactorialCalculator.calculateFactorial(3));
        assertEquals(24, FactorialCalculator.calculateFactorial(4));
        assertEquals(120, FactorialCalculator.calculateFactorial(5));
    }

    @Test
    void testFactorialOfLargeNumber() {
        assertEquals(3628800L, FactorialCalculator.calculateFactorial(10));
    }

    @Test
    void testFactorialOfNegativeNumber() {
        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-1);
        });

        assertThrows(IllegalArgumentException.class, () -> {
            FactorialCalculator.calculateFactorial(-5);
        }); 
    }

    @Test
    void testFactorialBoundaryValues() {
        assertEquals(2, FactorialCalculator.calculateFactorial(2));

        // Факториал 20 — максимальное значение, которое помещается в long
        // (20! = 2432902008176640000)
        assertEquals(2432902008176640000L, FactorialCalculator.calculateFactorial(20));
    }
}
