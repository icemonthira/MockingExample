package com.calculator;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Calculator {

    public int add(String numbers) {
        if (numbers.equals("")){
            return 0;

        } else {

            numbers = numbers.replaceAll("[^0-9-]", " ");
            List<String> numberList = Arrays.asList(numbers.trim().split(" "));
            List<Integer> negativeNumbers = numberList.stream()
                    .map(Integer::parseInt).filter(i -> i < 0)
                    .collect(Collectors.toList());
            if(!negativeNumbers.isEmpty()) {
                throw new RuntimeException("Input contains negative numbers " + negativeNumbers);
            }
            return numberList.stream().mapToInt(Integer::parseInt).sum();
        }


    }
}


















