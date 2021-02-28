package com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions;

public class EmptyAnswerTextException extends RuntimeException {
    public EmptyAnswerTextException(String s) {
        super(s);
    }
}
