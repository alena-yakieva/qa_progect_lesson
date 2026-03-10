package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class TriangleAreaTest {

    @Test
     void testIsValidTriangle_ValidScalene() {
        assertTrue(TriangleArea.isValidTriangle(3, 4, 5));
    }

    @Test
    void testIsValidTriangle_ValidEquilateral() {
        assertTrue(TriangleArea.isValidTriangle(5, 5, 5));
    }

    @Test
    void testIsValidTriangle_ValidIsosceles() {
        assertTrue(TriangleArea.isValidTriangle(5, 5, 8));
    }

    @Test
    void testIsValidTriangle_SumEqual() {
        assertFalse(TriangleArea.isValidTriangle(1, 2, 3)); 
    }

    @Test
    void testIsValidTriangle_SumLess() {
        assertFalse(TriangleArea.isValidTriangle(1, 1, 3)); 
    }

    @Test
    void testIsValidTriangle_NegativeSides() {
        assertFalse(TriangleArea.isValidTriangle(-1, 2, 2));
        assertFalse(TriangleArea.isValidTriangle(2, -1, 2));
        assertFalse(TriangleArea.isValidTriangle(2, 2, -1));
    }

    @Test
    void testIsValidTriangle_ZeroSides() {
        assertFalse(TriangleArea.isValidTriangle(0, 2, 2));
        assertFalse(TriangleArea.isValidTriangle(2, 0, 2));
        assertFalse(TriangleArea.isValidTriangle(2, 2, 0));
    }

    @Test
    void testCalculateArea_RightTriangle() {
        double area = TriangleArea.calculateArea(3, 4, 5);
        assertEquals(6.0, area, 0.001);
    }

    @Test
    void testCalculateArea_EquilateralTriangle() {
        double area = TriangleArea.calculateArea(5, 5, 5);
        assertEquals(10.825, area, 0.001);
    }

    @Test
    void testCalculateArea_IsoscelesTriangle() {
        double area = TriangleArea.calculateArea(5, 5, 6);
        assertEquals(12.0, area, 0.001);
    }

    @Test
    void testCalculateArea_SmallSides() {
        double area = TriangleArea.calculateArea(0.5, 0.5, 0.5);
        assertEquals(0.108, area, 0.001);
    }

    @Test
    void testCalculateArea_LargeSides() {
        double area = TriangleArea.calculateArea(100, 100, 100);
        assertEquals(4330.127, area, 0.001);
    }

    @Test
    void testCalculateArea_WithDecimalSides() {
        double area = TriangleArea.calculateArea(3.5, 4.2, 5.1);
        assertEquals(7.286, area, 0.001);
    }
}
<<<<<<< HEAD

=======
>>>>>>> 76e748fccc22572bac963095970d65acb8b946a6
