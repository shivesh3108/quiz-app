package com.micro_service.quiz_app.service;

import com.micro_service.quiz_app.dao.QuestionDao;
import com.micro_service.quiz_app.model.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuestionService {

    @Autowired
    QuestionDao questionDao;

    public ResponseEntity<List<Question>> getAllQuestion() {
        try {
            return new ResponseEntity<>(questionDao.findAll(), HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.BAD_REQUEST);

    }

    public ResponseEntity<Question> getQuestionById(int id) {
        try {
            return new ResponseEntity<>(questionDao.findById(id).orElse(null), HttpStatus.OK);
        } catch (Exception e){
            return new ResponseEntity<>(new Question(), HttpStatus.BAD_REQUEST);
        }
    }

    public List<Question> getQuestionByCategory(String category) {
        return questionDao.findByCategory(category);
    }

    public ResponseEntity<String> addQuestion(Question question) {
        questionDao.save(question);
        return new ResponseEntity<>("success", HttpStatus.CREATED);
    }

    public String deleteQuestion(int id) {
        questionDao.deleteById(id);
        return "Deleted";
    }

    public String updateQuestion(Question question) {
        questionDao.save(question);
        return "updated";
    }
}
