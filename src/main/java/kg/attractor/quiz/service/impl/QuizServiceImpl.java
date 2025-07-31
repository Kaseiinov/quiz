package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.OptionDao;
import kg.attractor.quiz.dao.QuestionDao;
import kg.attractor.quiz.dao.QuizDao;
import kg.attractor.quiz.dto.OptionDto;
import kg.attractor.quiz.dto.QuestionDto;
import kg.attractor.quiz.dto.QuestionOptionDto;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import kg.attractor.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {
    private final QuizDao quizDao;
    private final QuestionDao questionDao;
    private final OptionDao optionDao;



    @Override
    public QuizDto findById(Long id) {
        Quiz quiz = quizDao.findById(id);
        List<Question> questions = questionDao.findQuestionsByQuizId(quiz.getId());
        List<Option> options = new ArrayList<>();
        for (Question question : questions) {
            options.addAll(optionDao.findByQuestionId(question.getId()));
        }
        List<QuestionDto> questionDtos = questions
                .stream()
                .map(q -> QuestionDto
                        .builder()
                        .id(q.getId())
                        .quiz_id(q.getQuizId())
                        .question(q.getQuestion())
                        .build()
                ).toList();
        List<OptionDto> optionDtos = options
                .stream()
                .map(o -> OptionDto
                        .builder()
                        .question_id(o.getQuestionId())
                        .option(o.getOption())
                        .isCorrect(null)
                        .build()
                ).toList();

        List<QuestionOptionDto> qo = new ArrayList<>();
        for (QuestionDto question : questionDtos) {
            QuestionOptionDto newQO = new QuestionOptionDto();
            newQO.setQuestion(question.getQuestion());
            for (OptionDto option : optionDtos) {
                if(question.getId().equals(option.getQuestion_id())){
                    newQO.getOptions().add(option);
                }
            }
            qo.add(newQO);
        }


        return QuizDto
                .builder()
                .title(quiz.getTitle())
                .description(quiz.getDescription())
                .creatorId(quiz.getCreatorId())
                .questionOptions(qo)
                .build();

    }

    @Override
    public List<QuizDto> findQuizzes(){
        List<Quiz> quizzes = quizDao.findQuizzes();
        for(Quiz quiz : quizzes){
            quiz.setCountOfQuestions(quizDao.getCountOfQuestions(quiz.getId()));
        }
        return quizzes
                .stream()
                .map(q -> QuizDto
                        .builder()
                        .title(q.getTitle())
                        .description(q.getDescription())
                        .creatorId(q.getCreatorId())
                        .countOfQuestions(q.getCountOfQuestions())
                        .build()).toList();

    }

    @Override
    public void createQuiz(QuizDto quizDto) {
        Quiz quiz = Quiz
                .builder()
                .title(quizDto.getTitle())
                .description(quizDto.getDescription())
                .creatorId(quizDto.getCreatorId())
                .build();

        Long quizId = quizDao.createQuiz(quiz);
        log.info("Quiz created: {} id: {}", quiz.getTitle(), quizId);

        List<QuestionOptionDto> questionOptions = quizDto.getQuestionOptions();

        for (QuestionOptionDto questionOptionDto : questionOptions) {
            Question question = Question
                    .builder()
                    .quizId(quizId)
                    .question(questionOptionDto.getQuestion())
                    .build();
            Long questionId = questionDao.createQuestion(question);
            log.info("Question created: {} id: {}", question.getQuestion(), questionId);

            for (OptionDto optionDto : questionOptionDto.getOptions()) {
                Option option = Option
                        .builder()
                        .questionId(questionId)
                        .option(optionDto.getOption())
                        .isCorrect(optionDto.getIsCorrect())
                        .build();
                optionDao.createOption(option);
                log.info("Option created: {}", option.getOption());
            }
        }
    }

}
