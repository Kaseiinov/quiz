package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.OptionDao;
import kg.attractor.quiz.dao.QuestionDao;
import kg.attractor.quiz.dao.QuizDao;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import kg.attractor.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {
    private final QuizDao quizDao;
    private final QuestionDao questionDao;
    private final OptionDao optionDao;

    @Override
    public void createQuiz(QuizDto quizDto) {
        Quiz quiz = Quiz.builder()
                .title(quizDto.getTitle())
                .description(quizDto.getDescription())
                .creatorId(quizDto.getCreatorId())
                .build();

        Long quizId = quizDao.createQuiz(quiz);
        log.info("Quiz created: {} id: {}", quiz.getTitle(), quizId);

        Question question = Question.builder()
                .quizId(quizId)
                .question(quizDto.getQuestion().getQuestion())
                .build();

        Long questionId = questionDao.createQuestion(question);
        log.info("Question created: {} id: {}", question.getQuestion(), questionId);

        List<Option> optionList = quizDto.getOptions().stream()
                .map(o -> Option.builder()
                        .questionId(questionId)
                        .option(o.getOption())
                        .isCorrect(o.getIsCorrect())
                        .build())
                .toList();

        for (Option option : optionList) {
            optionDao.createOption(option);
            log.info("Option created: {}", option.getOption());
        }
    }

    @Override
    public List<Quiz> getAllQuizzes() {
        // TODO: заменить на quizDao.getAllQuizzes() после реализации
        log.warn("Stub: returning empty quiz list");
        return Collections.emptyList();
    }

    @Override
    public Quiz getQuizById(Long id) {
        // TODO: заменить на quizDao.getQuizById(id) после реализации
        log.warn("Stub: returning empty quiz");
        return new Quiz();
    }

    @Override
    public void deleteQuiz(Long id) {
        // TODO: заменить на quizDao.deleteQuiz(id) после реализации
        log.warn("Stub: deleteQuiz called with id = {}", id);
    }
}