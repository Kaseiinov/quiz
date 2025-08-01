package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.AnswerDto;
import kg.attractor.quiz.dto.QuizDto;

import java.util.List;

public interface QuizService {
    String getAnser(AnswerDto answerDto);

    QuizDto findById(Long id);

    List<QuizDto> findQuizzes();

    void createQuiz(QuizDto quizDto);
}
