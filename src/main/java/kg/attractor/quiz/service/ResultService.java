package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.ResultDto;

import java.util.List;

public interface ResultService {
    void saveResult(ResultDto dto);
    List<ResultDto> getResultsByQuizId(Long quizId);
}