package com.tekwill.java.fundamentals.triviaspringboot.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions.EmptyAnswerTextException;
import lombok.Data;

@Data
public class Answer {
    private Long id;
    private String text;
    private boolean isCorrect;
    private String letter;

    @JsonIgnore
    private Question question;

    public Answer() {
    }

    public Answer(Long id, String text, boolean isCorrect, String letter) {
        this(text, isCorrect, letter);
        this.id = id;
    }

    public Answer(String text, boolean isCorrect, String letter) {
        if (text.isEmpty())
            throw new EmptyAnswerTextException("Answer text should not be empty");
        this.text = text;
        this.isCorrect = isCorrect;
        this.letter = letter;
    }

    @Override
    public String toString() {
        return letter + ". " + text;
    }
}
