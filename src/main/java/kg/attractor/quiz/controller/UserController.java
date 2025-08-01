package kg.attractor.quiz.controller;

import jakarta.validation.Valid;
import kg.attractor.quiz.dto.UserDto;
import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.service.QuizService;
import kg.attractor.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final QuizService quizService;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    @GetMapping("/quizzes")
    public ResponseEntity<List<QuizDto>> getAllQuizzes() {
        return ResponseEntity.ok(quizService.findQuizzes());
    }

    @GetMapping("/quizzes/{id}")
    public ResponseEntity<QuizDto> getQuizById(@PathVariable Long id) {
        return ResponseEntity.ok(quizService.findById(id));
    }
}