package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.OptionDto;

import java.util.List;

public interface OptionService {
    void createOption(Long questionId, OptionDto dto);

    List<OptionDto> getOptionsByQuestionId(Long questionId);
}