package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.model.Quiz;

import java.util.List;

public interface QuizService {
    void createQuiz(QuizDto quizDto);

    List<Quiz> getAllQuizzes();

    Quiz getQuizById(Long id);

    void deleteQuiz(Long id);
}