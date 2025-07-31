package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.QuestionDao;
import kg.attractor.quiz.dto.QuestionDto;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.service.QuestionService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService {

    private final QuestionDao questionDao;

    @Override
    public List<QuestionDto> getQuestionsByQuizId(Long quizId) {
        return questionDao.getQuestionsByQuizId(quizId).stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public QuestionDto createQuestion(QuestionDto dto) {
        Question question = Question.builder()
                .quizId(dto.getQuizId())
                .question(dto.getQuestion())
                .build();

        Long id = questionDao.createQuestion(question);
        question.setId(id);
        return toDto(question);
    }

    @Override
    public List<QuestionDto> getAllQuestions() {
        return questionDao.getAllQuestions()
                .stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public QuestionDto getQuestionById(Long id) {
        Question question = questionDao.getQuestionById(id);
        return toDto(question);
    }

    @Override
    public QuestionDto updateQuestion(Long id, QuestionDto dto) {
        Question existing = questionDao.getQuestionById(id);
        existing.setQuestion(dto.getQuestion());
        questionDao.updateQuestion(existing);
        return toDto(existing);
    }

    @Override
    public void deleteQuestion(Long id) {
        questionDao.deleteQuestion(id);
    }

    private QuestionDto toDto(Question question) {
        return QuestionDto.builder()
                .question(question.getQuestion())
                .quizId(question.getQuizId())
                .build();
    }
}