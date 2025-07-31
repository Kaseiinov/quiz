package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.OptionDao;
import kg.attractor.quiz.dto.OptionDto;
import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class OptionServiceImpl implements OptionService {

    private final OptionDao optionDao;

    @Override
    public void createOption(Long questionId, OptionDto dto) {
        Option option = Option.builder()
                .option(dto.getOption())
                .isCorrect(dto.getIsCorrect())
                .questionId(questionId)
                .build();
        optionDao.createOption(option);
    }

    @Override
    public List<OptionDto> getOptionsByQuestionId(Long questionId) {
        return optionDao.getOptionsByQuestionId(questionId).stream()
                .map(opt -> OptionDto.builder()
                        .option(opt.getOption())
                        .isCorrect(opt.getIsCorrect())
                        .build())
                .toList();
    }
}