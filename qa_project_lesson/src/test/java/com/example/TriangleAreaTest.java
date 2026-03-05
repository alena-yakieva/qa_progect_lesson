package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    @Test
    void testValidTriangle() {
        assertTrue(TriangleArea.isValidTriangle(3, 4, 5));
        assertTrue(TriangleArea.isValidTriangle(5, 12, 11));
        assertTrue(TriangleArea.isValidTriangle(7, 8, 6));
    }

     @Test
    void testNegativeSides() {
        assertFalse(TriangleArea.isValidTriangle(-1, 2, 3));
        assertFalse(TriangleArea.isValidTriangle(1, -2, 3));
        assertFalse(TriangleArea.isValidTriangle(1, 2, -3));
    }

    @Test
    void testZeroSides() {
        assertFalse(TriangleArea.isValidTriangle(0, 2, 3));
        assertFalse(TriangleArea.isValidTriangle(1, 0, 3));
        assertFalse(TriangleArea.isValidTriangle(1, 2, 0));
    }

    @Test
    void testCalculateAreaRightTriangle() {
        assertEquals(6.0, TriangleArea.calculateArea(3, 4, 5), 0.001);
    }

    @Test
    void testCalculateAreaEquilateralTriangle() {
        assertEquals(15.588, TriangleArea.calculateArea(6, 6, 6), 0.001);
    }

    @Test
    void testCalculateAreaIsoscelesTriangle() {
        assertEquals(12.0, TriangleArea.calculateArea(5, 5, 6), 0.001);
    }

    @Test
    void testCalculateAreaWithLargeNumbers() {
        assertEquals(4330.127, TriangleArea.calculateArea(100, 100, 100), 0.001);
    }

    @Test
    void testAreaOfInvalidTriangle() {
        assertThrows(IllegalArgumentException.class, () -> {
            if (!TriangleArea.isValidTriangle(1, 2, 3)) {
                throw new IllegalArgumentException("Треугольник не существует");
            }
            TriangleArea.calculateArea(1, 2, 3);
        });
    }

    @Test
    void testEdgeCases() {
        assertTrue(TriangleArea.isValidTriangle(0.1, 0.1, 0.1));
        assertEquals(0.00433, TriangleArea.calculateArea(0.1, 0.1, 0.1), 0.00001);
        assertTrue(TriangleArea.isValidTriangle(1e6, 1e6, 1e6));
    }

    @Test
    void testPrecision() {
        double area = TriangleArea.calculateArea(3.5, 4.2, 5.1);
        assertTrue(area > 7.0 && area < 8.0);
    }

}
