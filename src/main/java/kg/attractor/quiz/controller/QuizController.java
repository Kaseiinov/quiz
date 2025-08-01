package kg.attractor.quiz.controller;

import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.service.impl.QuizServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizServiceImpl quizService;

    @PostMapping
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto) {
        quizService.createQuiz(quizDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Quiz created");
    }
}
