package com.tekwill.java.fundamentals.triviaspringboot.repository;


import com.tekwill.java.fundamentals.triviaspringboot.domain.Question;

import java.util.List;

public interface QuestionRepository {
    List<Question> findQuestionsByLevel(int level);

    boolean save(Question question);

    boolean delete(Question question);

    boolean deleteById(Long questionId);

    List<Question> findAll();
}
