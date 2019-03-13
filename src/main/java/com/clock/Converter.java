package com.clock;

public interface Converter<T> {

    T convert(String numbersToConvert);
}
