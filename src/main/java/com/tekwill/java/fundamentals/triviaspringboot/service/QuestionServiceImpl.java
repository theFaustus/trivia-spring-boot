package com.tekwill.java.fundamentals.triviaspringboot.service;

import com.tekwill.java.fundamentals.triviaspringboot.domain.Question;
import com.tekwill.java.fundamentals.triviaspringboot.domain.exceptions.InvalidLevelException;
import com.tekwill.java.fundamentals.triviaspringboot.repository.QuestionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {
    private final QuestionRepository questionRepository;

    @Override
    public List<Question> getQuestionsByLevel(int level) {
        List<Question> questionsByLevel = questionRepository.findQuestionsByLevel(level);
        Collections.shuffle(questionsByLevel);
        if(questionsByLevel.isEmpty())
            throw new InvalidLevelException(String.format("Questions not found for level %s", level));
        return questionsByLevel;
    }

    @Override
    public Long save(Question question) {
        return questionRepository.save(question);
    }

    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findQuestionById(questionId);
    }

    @Override
    public boolean delete(Question question) {
        return questionRepository.delete(question);
    }

    @Override
    public boolean deleteById(Long questionId) {
        return questionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> getAll() {
        return questionRepository.findAll();
    }


}
