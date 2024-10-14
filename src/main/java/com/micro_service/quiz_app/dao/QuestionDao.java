package com.micro_service.quiz_app.dao;

import com.micro_service.quiz_app.model.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionDao extends JpaRepository<Question, Integer> {

    List<Question> findByCategory(String category);

    @Query(value = "select * from question q where q.category = :category order by random() limit :noOfQuestions", nativeQuery = true)
    List<Question> getRandomQuestionByCategory(String category, int noOfQuestions);
}
