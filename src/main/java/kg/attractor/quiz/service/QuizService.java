package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.AnswerDto;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.dto.ResultDto;
import kg.attractor.quiz.dto.StatisticsDto;
import kg.attractor.quiz.exception.AlreadyCompletedException;

import java.util.List;
import java.util.Map;

public interface QuizService {

    List<StatisticsDto> getLeaderBoard(Long quizId);

    ResultDto getResult(Long quizId);

    Map<Long, String> getAnswers(List<AnswerDto> answersDto, Long userId) throws AlreadyCompletedException;

    QuizDto findById(Long id);

    List<QuizDto> findQuizzes();

    void createQuiz(QuizDto quizDto);
}
