package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void addition() {
        int sum = calculator.add("");
        int sum2 = calculator.add("1,2");
        int sum3 = calculator.add("5lol,,,,");

        assertEquals(0, sum);
        assertEquals(3, sum2);
        assertEquals(5, sum3);


    }
}