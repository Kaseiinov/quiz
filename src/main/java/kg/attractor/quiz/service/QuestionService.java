package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.QuestionDto;

import java.util.List;

public interface QuestionService {
    List<QuestionDto> getAllQuestions();
    List<QuestionDto> getQuestionsByQuizId(Long quizId);
    QuestionDto getQuestionById(Long id);
    QuestionDto createQuestion(QuestionDto dto);
    QuestionDto updateQuestion(Long id, QuestionDto dto);
    void deleteQuestion(Long id);
}