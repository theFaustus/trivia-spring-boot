package com.tekwill.java.fundamentals.triviaspringboot.controller;

import com.tekwill.java.fundamentals.triviaspringboot.domain.Question;
import com.tekwill.java.fundamentals.triviaspringboot.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/questions")
@RequiredArgsConstructor
public class QuestionsController {
    private final QuestionService questionService;

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Question>> getAllQuestions(){
        final List<Question> all = questionService.getAll();
        return ResponseEntity.ok(all);
    }

    @GetMapping(value = "/{level}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Question>> getQuestionsByLevel(@PathVariable Integer level){
        final List<Question> byLevel = questionService.getQuestionsByLevel(level);
        return ResponseEntity.ok(byLevel);
    }

    @DeleteMapping(value = "/delete/{questionId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> deleteQuestionById(@PathVariable Long questionId){
        questionService.deleteById(questionId);
        return ResponseEntity.ok().build();
    }

    @PostMapping( produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> deleteQuestionById(@RequestBody Question question){
        question.getAnswers().forEach(q -> q.setQuestion(question));
        questionService.save(question);
        return ResponseEntity.ok("Question created");
    }
}