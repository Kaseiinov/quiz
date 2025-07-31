package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.ResultDao;
import kg.attractor.quiz.dto.ResultDto;
import kg.attractor.quiz.model.Result;
import kg.attractor.quiz.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ResultServiceImpl implements ResultService {

    private final ResultDao resultDao;

    @Override
    public void saveResult(ResultDto dto) {
        Result result = Result.builder()
                .score(dto.getScore())
                .userId(dto.getUserId())
                .quizId(dto.getQuizId())
                .build();

        resultDao.saveResult(result);
    }

    @Override
    public List<ResultDto> getResultsByQuizId(Long quizId) {
        return resultDao.getResultsByQuizId(quizId).stream()
                .map(r -> ResultDto.builder()
                        .score(r.getScore())
                        .userId(r.getUserId())
                        .quizId(r.getQuizId())
                        .build())
                .collect(Collectors.toList());
    }
}