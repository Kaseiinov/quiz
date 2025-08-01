package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.AnswerDto;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.dto.ResultDto;

import java.util.List;
import java.util.Map;

public interface QuizService {

    ResultDto getResult(Long quizId);

    Map<Long, String> getAnswers(List<AnswerDto> answersDto, Long userId);

    QuizDto findById(Long id);

    List<QuizDto> findQuizzes();

    void createQuiz(QuizDto quizDto);
}
