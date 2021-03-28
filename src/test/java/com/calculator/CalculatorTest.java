package com.calculator;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void addition (){
        int sum = calculator.add("");

        assertEquals(0, sum);

    }
}