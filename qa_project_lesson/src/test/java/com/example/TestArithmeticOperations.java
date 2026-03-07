package com.example;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestArithmeticOperations {

    @DataProvider(name = "addition-data")
    public Object[][] provideAdditionData() {
        return new Object[][] {
            {2, 3, 5, "Сложение положительных чисел"},
            {0, 0, 0, "Сложение нулей"},
            {-5, 3, -2, "Сложение отрицательного и положительного"},
            {100, -50, 50, "Сложение с отрицательным"},
            {Integer.MAX_VALUE - 1, 1, Integer.MAX_VALUE, "Близко к переполнению"}
        };
    }

    @Test(dataProvider = "addition-data")
    public void testAddition(int a, int b, int expected, String message) {
        Assert.assertEquals(a + b, expected, message);
    }

    @DataProvider(name = "multiplication-data")
    public Object[][] provideMultiplicationData() {
        return new Object[][] {
            {4, 5, 20, "Умножение положительных"},
            {0, 100, 0, "Умножение на ноль"},
            {-3, 4, -12, "Отрицательное * положительное"},
            {-2, -5, 10, "Отрицательное * отрицательное"},
            {1, 42, 42, "Умножение на 1"},
        };
    }

    @Test(dataProvider = "multiplication-data")
    public void testMultiplication(int a, int b, int expected, String message) {
        Assert.assertEquals(a * b, expected, message);
    }

    @DataProvider(name = "subtraction-data")
    public Object[][] provideSubtractionData() {
        return new Object[][] {
            {10, 3, 7, "Обычное вычитание"},
            {5, 5, 0, "Вычитание одинаковых чисел"},
            {0, 5, -5, "Вычитание из нуля"},
            {-3, 2, -5, "Вычитание с отрицательными"},
            {Integer.MIN_VALUE + 5, 5, Integer.MIN_VALUE, "Близко к минимальному"}
        };
    }
    @Test(dataProvider = "subtraction-data")
    public void testSubtraction(int a, int b, int expected, String message) {
        Assert.assertEquals(a - b, expected, message);
    }

     @DataProvider(name = "division-data")
    public Object[][] provideDivisionData() {
        return new Object[][] {
            {20, 4, 5, "Обычное деление"},
            {7, 2, 3, "Целочисленное деление"},
            {-10, 2, -5, "Отрицательное делимое"},
            {15, -3, -5, "Отрицательный делитель"},
            {42, 1, 42, "Деление на 1"}
        };
    }

        @Test(dataProvider = "division-data")
    public void testDivision(int a, int b, int expected, String message) {
        Assert.assertEquals(a / b, expected, message);
    }

     @Test(expectedExceptions = ArithmeticException.class)
    public void testDivisionByZero() {
        performDivision(10, 0);
    }
        private int performDivision(int a, int b) {
            return a / b;
        }
    

     @DataProvider(name = "modulo-data")
    public Object[][] provideModuloData() {
        return new Object[][] {
            {10, 3, 1, "Обычный остаток"},
            {8, 4, 0, "Остаток 0"},
            {7, 10, 7, "Делимое меньше делителя"},
            {-7, 3, -1, "Отрицательное делимое (результат: -1)"},
            {7, -3, 1, "Отрицательный делитель (результат: 1)"}
        };
    }

    @Test(dataProvider = "modulo-data")
    public void testModulo(int a, int b, int expected, String message) {
        Assert.assertEquals(a % b, expected, message);
    }

      @DataProvider(name = "complex-expressions")
    public Object[][] provideComplexExpressions() {
        return new Object[][] {
            {"(2 + 3) * 4", 20, 20},
            {"2 + 3 * 4", 14, 14},
            {"10 / 2 + 3", 8, 8},
            {"5 + 2 * 3 - 1", 10, 10}
        };
    }

    @Test(dataProvider = "complex-expressions")
    public void testComplexExpressions(String expression, int result, int expected) {
        Assert.assertEquals(result, expected, "Выражение: " + expression);
    }
}

   