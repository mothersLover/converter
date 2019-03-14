package com.clock;

public interface Converter<Return, Income> {

    Return convert(Income numbersToConvert);
}
