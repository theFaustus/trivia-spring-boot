package com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions;

public class InvalidLevelException extends RuntimeException {
    public InvalidLevelException(String s) {
        super(s);
    }
}
