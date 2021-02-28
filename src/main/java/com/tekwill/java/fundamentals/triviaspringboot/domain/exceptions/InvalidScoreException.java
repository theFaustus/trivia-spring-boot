package com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions;

public class InvalidScoreException extends RuntimeException {
    public InvalidScoreException(String s) {
        super(s);
    }
}
