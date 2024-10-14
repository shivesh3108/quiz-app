package com.micro_service.quiz_app.controller;

import com.micro_service.quiz_app.model.Question;
import com.micro_service.quiz_app.model.QuestionWrapper;
import com.micro_service.quiz_app.model.Response;
import com.micro_service.quiz_app.service.QuizService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("quiz")
public class QuizController {

    @Autowired
    QuizService quizService;


//    http://localhost:8090/quiz/create?category=Java&NoOfQuestions=5&title=JavaQuiz
    @PostMapping("create")
    public ResponseEntity<String> createQuiz(@RequestParam String category, @RequestParam int NoOfQuestions, @RequestParam String title){
        return quizService.createQuiz(category, NoOfQuestions, title);
    }

//    http://localhost:8090/quiz/get/1
    @GetMapping("get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable int id){
        return quizService.getQuizQuestion(id);
    }

//    http://localhost:8090/quiz/get/1
    @PostMapping("submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResult(id, responses);
    }
}
