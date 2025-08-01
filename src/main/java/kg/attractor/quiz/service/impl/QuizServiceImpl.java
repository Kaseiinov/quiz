package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.OptionDao;
import kg.attractor.quiz.dao.QuestionDao;
import kg.attractor.quiz.dao.QuizDao;
import kg.attractor.quiz.dao.UserDao;
import kg.attractor.quiz.dto.*;
import kg.attractor.quiz.exception.NotFoundException;
import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import kg.attractor.quiz.model.User;
import kg.attractor.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class QuizServiceImpl implements QuizService {
    private final QuizDao quizDao;
    private final QuestionDao questionDao;
    private final OptionDao optionDao;
    private final UserDao userDao;

    @Override
    public ResultDto getResult(Long quizId) {
        Quiz quiz = quizDao.findById(quizId);
        List<Question> questions = questionDao.findQuestionsByQuizId(quizId);
        List<Option> options = new ArrayList<>();
        for (Question question : questions) {
            options.addAll(optionDao.findByQuestionId(question.getId()));
        }
        List<Option> correctOptions = new ArrayList<>();
        for (Option option : options) {
            if(option.getIsCorrect()) {
                correctOptions.add(option);
            }
        }
        List<OptionDto> optionDtos = correctOptions
                .stream()
                .map(o -> OptionDto
                        .builder()
                        .id(o.getId())
                        .question_id(o.getQuestionId())
                        .option(o.getOption())
                        .isCorrect(o.getIsCorrect())
                        .build()).toList();

        List<QuestionDto> questionDtos = questions
                .stream()
                .map(o -> QuestionDto
                        .builder()
                        .id(o.getId())
                        .quiz_id(o.getQuizId())
                        .question(o.getQuestion())
                        .build()).toList();

        List<QuestionOptionDto> qos = new ArrayList<>();
        for (QuestionDto question : questionDtos) {
            QuestionOptionDto questionOptionDto = new QuestionOptionDto();
            questionOptionDto.setQuestion(question);
            for(OptionDto option : optionDtos) {
                if(option.getQuestion_id().equals(question.getId())){
                    questionOptionDto.getOptions().add(option);
                }
            }
            qos.add(questionOptionDto);

        }

        int correctOptionsCount = 0;
        for (Option option : options) {
            if(option.getIsCorrect()){
                correctOptionsCount += 1;
            }
        }
        ResultDto resultDto = new ResultDto();
        resultDto.setCountQuestions(questions.size());
        resultDto.setCountCorrectOptions(correctOptionsCount);
        resultDto.setQuestionOptionDtos(qos);
        resultDto.setOptions(options.size());
        return resultDto;
    }

    @Override
    public Map<Long, String> getAnswers(List<AnswerDto> answersDto, Long userId) {
        User user = userDao.findById(userId).orElseThrow(NotFoundException::new);

        Map<Long, String> results = new HashMap<>();
        int correctCount = 0;

        for (AnswerDto answerDto : answersDto) {
            Question question = questionDao.getQuestionById(answerDto.getQuestionId())
                    .orElseThrow(NotFoundException::new);

            Quiz quiz = quizDao.findByQuestionId(question.getId())
                    .orElseThrow(NotFoundException::new);

            List<Option> options = optionDao.findByQuestionId(question.getId());

            Option selectedOption = options.stream()
                    .filter(option -> option.getId().equals(answerDto.getSelectedOptionId()))
                    .findFirst()
                    .orElseThrow(NotFoundException::new);

            if (selectedOption.getIsCorrect()) {
                results.put(question.getId(), "Correct");
                correctCount++;
            } else {
                results.put(question.getId(), "Incorrect");
            }
        }

        if (!answersDto.isEmpty()) {
            Long quizId = quizDao.findByQuestionId(answersDto.getFirst().getQuestionId())
                    .orElseThrow(NotFoundException::new).getId();

            quizDao.setScore(quizId, userId, (double) correctCount);
        }

        return results;
    }


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
                        .id(o.getId())
                        .question_id(o.getQuestionId())
                        .option(o.getOption())
                        .isCorrect(null)
                        .build()
                ).toList();

        List<QuestionOptionDto> qo = new ArrayList<>();
        for (QuestionDto question : questionDtos) {
            QuestionOptionDto newQO = new QuestionOptionDto();
            newQO.setQuestion(question);
            for (OptionDto option : optionDtos) {
                if(question.getId().equals(option.getQuestion_id())){
                    newQO.getOptions().add(option);
                }
            }
            qo.add(newQO);
        }


        return QuizDto
                .builder()
                .id(quiz.getId())
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
                .id(quizDto.getId())
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
                    .question(questionOptionDto.getQuestion().getQuestion())
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
