import com.example.ArithmeticOperations;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArithmeticOperationsTest {

    @Test public
     void testAddPositiveNumbers() {
        assertEquals(5, ArithmeticOperations.add(2, 3));
    }

    @Test
    void testAddNegativeNumbers() {
        assertEquals(-5, ArithmeticOperations.add(-2, -3));
    }

    @Test
    void testAddMixedNumbers() {
        assertEquals(1, ArithmeticOperations.add(-2, 3));
    }

    @Test
    void testSubtractPositiveNumbers() {
        assertEquals(2, ArithmeticOperations.subtract(5, 3));
    }

    @Test
    void testSubtractNegativeNumbers() {
        assertEquals(-2, ArithmeticOperations.subtract(-5, -3));
    }

    @Test
    void testSubtractMixedNumbers() {
        assertEquals(8, ArithmeticOperations.subtract(5, -3));
    }

    @Test
    void testMultiplyPositiveNumbers() {
        assertEquals(15, ArithmeticOperations.multiply(3, 5));
    }

    @Test
    void testMultiplyNegativeNumbers() {
        assertEquals(15, ArithmeticOperations.multiply(-3, -5));
    }

    @Test
    void testMultiplyByZero() {
        assertEquals(0, ArithmeticOperations.multiply(10, 0));
    }

    @Test
    void testDividePositiveNumbers() {
        assertEquals(2.0, ArithmeticOperations.divide(10, 5), 0.0001);
    }

    @Test
    void testDivideWithRemainder() {
        assertEquals(2.5, ArithmeticOperations.divide(5, 2), 0.0001);
    }

    @Test
    void testDivideNegativeNumbers() {
        assertEquals(2.0, ArithmeticOperations.divide(-10, -5), 0.0001);
    }

    @Test
    void testDivideMixedSigns() {
        assertEquals(-2.0, ArithmeticOperations.divide(10, -5), 0.0001);
    }

    @Test
    void testDivideByZero() {
        assertThrows(ArithmeticException.class, () -> ArithmeticOperations.divide(10, 0));
    }
    @Test
    void testAddWithZero() {
        assertEquals(5, ArithmeticOperations.add(5, 0));
    }
    @Test
    void testSubtractWithZero() {
        assertEquals(5, ArithmeticOperations.subtract(5, 0));
    }
}





