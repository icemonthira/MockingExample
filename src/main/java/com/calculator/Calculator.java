package com.calculator;

import java.util.Arrays;
import java.util.List;

public class Calculator {

    public int add(String numbers) {
        if (numbers.equals("")){
            return 0;

        } else {

            numbers = numbers.replaceAll("[^0-9]+", " ");
            List<String> numberList = Arrays.asList(numbers.trim().split(" "));
            return numberList.stream().mapToInt(Integer::parseInt).sum();
        }


    }
}


















