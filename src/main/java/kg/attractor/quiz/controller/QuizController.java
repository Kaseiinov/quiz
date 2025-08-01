package kg.attractor.quiz.controller;

import jakarta.validation.Valid;
import kg.attractor.quiz.dto.AnswerDto;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class QuizController {

    private final QuizService quizService;

    @PostMapping("/{quizId}/solve")
    public ResponseEntity<String> getAnswer(@RequestBody @Valid AnswerDto answerDto, @PathVariable Long quizId) {
        return ResponseEntity.status(HttpStatus.CREATED).body(quizService.getAnser(answerDto));
    }

    @PostMapping
    public ResponseEntity<String> createQuiz(@Valid @RequestBody QuizDto quizDto) {
        quizService.createQuiz(quizDto);
        return ResponseEntity.status(HttpStatus.CREATED).body("Quiz created");
    }

    @GetMapping
    public ResponseEntity<List<QuizDto>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.findQuizzes());
    }

    @GetMapping("/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findById(id));
    }
}
