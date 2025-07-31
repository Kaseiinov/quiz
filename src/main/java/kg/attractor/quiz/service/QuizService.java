package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.QuizDto;

import java.util.List;

public interface QuizService {
    QuizDto findById(Long id);

    List<QuizDto> findQuizzes();

    void createQuiz(QuizDto quizDto);
}
