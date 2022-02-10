package pl.nullpointerexception.p2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void shouldAddTwoNumbers() {
        // given
        int a = 7;
        int b = 7;
        // when
        int sum = Calculator.sum(a, b);
        // then
        assertEquals(14, sum);
    }

    @Test
    void shouldSubtractTwoNumbers() {
        // given
        int a = 7;
        int b = 7;
        // when
        int subtract = Calculator.subtract(a, b);
        // then
        assertEquals(0, subtract);
    }

    @Test
    void shouldMultiplyTwoNumber() {
        // given
        int a = 7;
        int b = 7;
        // when
        int multiply = Calculator.multiply(a, b);
        // then
        assertEquals(49, multiply);
    }

    @Test
    void shouldDivideTwoNumber() {
        // given
        int a = 7;
        int b = 7;
        // when
        float divide = Calculator.divide(a, b);
        // then
        assertEquals(1, divide);
    }

}