package com.clock;

import java.util.*;

public class RomanConverter implements Converter<Integer, String>, Validator<String> {
    private static Map<Character, Integer> romanToArabicMap = new HashMap<>();
    static {
        romanToArabicMap.put('I', 1);
        romanToArabicMap.put('V', 5);
        romanToArabicMap.put('X', 10);
        romanToArabicMap.put('L', 50);
        romanToArabicMap.put('C', 100);
        romanToArabicMap.put('D', 500);
        romanToArabicMap.put('M', 1000);
    }

    public Integer convert(String numbersToConvert) {
        validate(numbersToConvert);
        char[] symbols = numbersToConvert.toCharArray();
        Integer result = 0;
        Integer intermediateResult = 0;
        for (int i = 0; i < symbols.length; i++) {
            char first = symbols[i];
            if (i + 1 >= symbols.length) {
                result += romanToArabicMap.get(first);
                result += intermediateResult;
                break;
            }
            char second = symbols[i + 1];
            if (romanToArabicMap.get(first) > romanToArabicMap.get(second)) {
                result += romanToArabicMap.get(first);
                result += intermediateResult;
                intermediateResult = 0;
            }
            if (romanToArabicMap.get(first).equals(romanToArabicMap.get(second))) {
                intermediateResult += romanToArabicMap.get(first);
            }
            if (romanToArabicMap.get(first) < romanToArabicMap.get(second)) {
                int value = romanToArabicMap.get(second) - romanToArabicMap.get(first) - intermediateResult;
                i++;
                result += value;
            }
        }
        return result;
    }

    @Override
    public void validate(String valueToValidate) throws IllegalStateException {
        if (valueToValidate == null || ("").equals(valueToValidate)) {
            throw new IllegalStateException();
        }
        //todo implement check logic
    }
}
