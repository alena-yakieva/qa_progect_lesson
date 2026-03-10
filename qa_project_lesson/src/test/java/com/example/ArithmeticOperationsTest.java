package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    @Test
     void testAdd_PositiveNumbers() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
        assertEquals(100, ArithmeticOperations.add(50, 50));
    }

    @Test
    void testAdd_NegativeNumbers() {
        assertEquals(-5, ArithmeticOperations.add(-2, -3));
        assertEquals(0, ArithmeticOperations.add(-5, 5));
    }

    @Test
    void testAdd_WithZero() {
        assertEquals(5, ArithmeticOperations.add(5, 0));
        assertEquals(-3, ArithmeticOperations.add(-3, 0));
        assertEquals(0, ArithmeticOperations.add(0, 0));
    }

    @Test
    void testSubtract_PositiveResults() {
        assertEquals(2, ArithmeticOperations.subtract(5, 3));
        assertEquals(42, ArithmeticOperations.subtract(100, 58));
    }

    @Test
    void testSubtract_NegativeResults() {
        assertEquals(-2, ArithmeticOperations.subtract(3, 5));
        assertEquals(-42, ArithmeticOperations.subtract(58, 100));
    }

    @Test
    void testSubtract_WithZero() {
        assertEquals(5, ArithmeticOperations.subtract(5, 0));
        assertEquals(-7, ArithmeticOperations.subtract(-7, 0));
        assertEquals(0, ArithmeticOperations.subtract(0, 0));
    }

    @Test
    void testMultiply_PositiveNumbers() {
        assertEquals(6, ArithmeticOperations.multiply(2, 3));
        assertEquals(25, ArithmeticOperations.multiply(5, 5));
    }

    @Test
    void testMultiply_NegativeNumbers() {
        assertEquals(6, ArithmeticOperations.multiply(-2, -3));  
        assertEquals(-6, ArithmeticOperations.multiply(-2, 3)); 
        assertEquals(-6, ArithmeticOperations.multiply(2, -3)); 
    }

    @Test
    void testMultiply_WithZero() {
        assertEquals(0, ArithmeticOperations.multiply(0, 100));
        assertEquals(0, ArithmeticOperations.multiply(-50, 0));
        assertEquals(0, ArithmeticOperations.multiply(0, 0));
    }

    @Test
    void testDivide_PositiveResults() {
        assertEquals(2.0, ArithmeticOperations.divide(6, 3), 0.001);
        assertEquals(0.5, ArithmeticOperations.divide(1, 2), 0.001);
    }

    @Test
    void testDivide_NegativeResults() {
        assertEquals(-2.0, ArithmeticOperations.divide(-6, 3), 0.001);
        assertEquals(-0.5, ArithmeticOperations.divide(1, -2), 0.001);
        assertEquals(2.0, ArithmeticOperations.divide(-6, -3), 0.001);
    }

    @Test
    void testDivide_FractionalResults() {
        assertEquals(3.333, ArithmeticOperations.divide(10, 3), 0.001);
        assertEquals(0.333, ArithmeticOperations.divide(1, 3), 0.001);
    }

    @Test
    void testDivide_ByOne() {
        assertEquals(5.0, ArithmeticOperations.divide(5, 1), 0.001);
        assertEquals(-8.0, ArithmeticOperations.divide(-8, 1), 0.001);
    }

    @Test
    void testDivide_WithZeroNumerator() {
        assertEquals(0.0, ArithmeticOperations.divide(0, 5), 0.001);
        assertEquals(0.0, ArithmeticOperations.divide(0, -10), 0.001);
    }

    @Test
    void testDivide_ByZero_ThrowsException() {
        assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(5, 0);
        });

        ArithmeticException exception = assertThrows(ArithmeticException.class, () -> {
            ArithmeticOperations.divide(10, 0);
        });
        assertEquals("Деление на ноль", exception.getMessage());
    }

    @Test
    void testEdgeCases_IntegerBounds() {
        assertEquals(Integer.MAX_VALUE, ArithmeticOperations.add(Integer.MAX_VALUE - 1, 1));
        assertEquals(Integer.MIN_VALUE, ArithmeticOperations.subtract(Integer.MIN_VALUE + 1, 1));
        assertEquals(-Integer.MAX_VALUE, ArithmeticOperations.multiply(Integer.MAX_VALUE, -1));
    }

    @Test
    void testLargeNumbers() {
        assertEquals(2_000_000_000, ArithmeticOperations.add(1_000_000_000, 1_000_000_000));
        assertEquals(0, ArithmeticOperations.subtract(1_000_000_000, 1_000_000_000));
        assertEquals(1_000_000_000L, ArithmeticOperations.multiply(10_000, 100_000));
    }

    @Test
    void testOverflow_Add() {
        int result = ArithmeticOperations.add(Integer.MAX_VALUE, 1);
        assertEquals(Integer.MIN_VALUE, result); 
    }

    @Test
    void testOverflow_Multiply() {
        long expected = (long) Integer.MAX_VALUE * Integer.MAX_VALUE;
        int actual = ArithmeticOperations.multiply(Integer.MAX_VALUE, Integer.MAX_VALUE);
        assertNotEquals(expected, actual);

    }

}
<<<<<<< HEAD





=======
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
