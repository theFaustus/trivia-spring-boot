package com.tekwill.java.fundamentals.triviaspringboot.service;


import com.tekwill.java.fundamentals.triviaspringboot.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByLevel(int level);

    boolean save(Question question);

    boolean delete(Question question);

    List<Question> getAll();
}
