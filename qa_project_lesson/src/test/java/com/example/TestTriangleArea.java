package com.example;

import org.testng.Assert;
import org.testng.annotations.Test;

public class TestTriangleArea {

    @Test
    public void testValidTriangleEquilateral() {
        Assert.assertTrue(TriangleArea.isValidTriangle(4, 4, 4));
        double area = TriangleArea.calculateArea(4, 4, 4);
        Assert.assertEquals(area, 6.928203230275509, 0.001);
    }

    @Test
    public void testValidTriangleRightAngled() {
        Assert.assertTrue(TriangleArea.isValidTriangle(3, 4, 5));
        double area = TriangleArea.calculateArea(3, 4, 5);
        Assert.assertEquals(area, 6.0, 0.001);
    }

    @Test
    public void testValidTriangleIsosceles() {
         Assert.assertTrue(TriangleArea.isValidTriangle(5, 5, 8));
        double area = TriangleArea.calculateArea(5, 5, 8);
        Assert.assertEquals(area, 12.0, 0.001);
    }

     @Test
    public void testInvalidTriangleSumOfTwoSidesEqualsThird() {
        Assert.assertFalse(TriangleArea.isValidTriangle(1, 2, 3));
    }

    @Test
    public void testInvalidTriangleSumOfTwoSidesLessThanThird() {
        Assert.assertFalse(TriangleArea.isValidTriangle(1, 1, 3));
    }

    @Test
    public void testNegativeSide() {
        Assert.assertFalse(TriangleArea.isValidTriangle(-1, 2, 2));
    }

    @Test
    public void testZeroSide() {
        Assert.assertFalse(TriangleArea.isValidTriangle(0, 2, 2));
    }

    @Test
    public void testAllZeroSides() {
        Assert.assertFalse(TriangleArea.isValidTriangle(0, 0, 0));
    }

    @Test
    public void testVerySmallSides() {
        Assert.assertTrue(TriangleArea.isValidTriangle(0.1, 0.1, 0.1));
        double area = TriangleArea.calculateArea(0.1, 0.1, 0.1);
        Assert.assertEquals(area, 0.004330127018922193, 0.0001);
    }

    @Test
    public void testLargeSides() {
        Assert.assertTrue(TriangleArea.isValidTriangle(1000, 1000, 1000));
        double area = TriangleArea.calculateArea(1000, 1000, 1000);
        Assert.assertEquals(area, 433012.7018922193, 0.1);
    }

    @Test
    public void testDegenerateTriangle() {
        // площадь = 0
        Assert.assertFalse(TriangleArea.isValidTriangle(1, 1, 2));
    }

    @Test
    public void testFloatingPointPrecision() {
        Assert.assertTrue(TriangleArea.isValidTriangle(1.5, 2.5, 3.0));
        double area = TriangleArea.calculateArea(1.5, 2.5, 3.0);
        Assert.assertEquals(area, 1.8708286933869707, 0.001);
    }
}
