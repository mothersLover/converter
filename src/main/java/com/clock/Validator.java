package com.clock;

public interface Validator<T> {

    void validate(T valueToValidate) throws IllegalStateException;
}
