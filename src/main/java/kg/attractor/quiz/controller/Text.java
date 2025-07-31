package kg.attractor.quiz.controller;

import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.service.QuizService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quizzes")
@RequiredArgsConstructor
public class Text {
    private final QuizService quizService;

    @GetMapping("{id}")
    public ResponseEntity<QuizDto> findById(@PathVariable Long id) {
        QuizDto quizDto = quizService.findById(id);
        return ResponseEntity.ok(quizDto);
    }
}
