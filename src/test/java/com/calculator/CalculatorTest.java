package com.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    @DisplayName("Step 1")
    void addition() {
        int sum = calculator.add("");
        int sum2 = calculator.add("1,2");
        int sum3 = calculator.add("5lol,,,,");

        assertEquals(0, sum);
        assertEquals(3, sum2);
        assertEquals(5, sum3);
    }

    @Test
    @DisplayName("Step 2")
    void addingUnknownAmountOfNumbers() {
        int sumOfMulti = calculator.add("1,2,3,4,5,6,7,8,9");
        int answer = 1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9;

        assertEquals(answer, sumOfMulti);

    }

    @Test
    @DisplayName("Step 3")
    void addingNewLinesBetweenNumbers(){
        int sumWithNewLines = calculator.add("1\n2,3");

        assertEquals(6, sumWithNewLines);
    }

//    Step 4 is supported out of the box. The implementation
// does not care about specific delimiter. Will skip this test
//    @Test
//    @DisplayName("Step 4")


    @Test
    @DisplayName("Step 5")
    void doNotSupportNegativeNumbers(){
        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            calculator.add("-5,3,2");
        });

        String expectedMessage = "Input contains negative numbers ";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
    }


}

