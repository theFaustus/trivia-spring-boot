package com.tekwill.java.fundamentals.triviaspringboot.service;


import com.tekwill.java.fundamentals.triviaspringboot.domain.Question;

import java.util.List;

public interface QuestionService {
    List<Question> getQuestionsByLevel(int level);

    Long save(Question question);

    Question getQuestionById(Long questionId);

    boolean delete(Question question);

    boolean deleteById(Long questionId);

    List<Question> getAll();
}
