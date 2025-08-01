package kg.attractor.quiz.controller;

import jakarta.validation.Valid;
import kg.attractor.quiz.dto.UserDto;
import kg.attractor.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/register")
@RequiredArgsConstructor
public class AuthController {

    private final UserService userService;

    @PostMapping
    public ResponseEntity<String> registerUser(@Valid @RequestBody UserDto userDto) {
        userService.register(userDto);
        return ResponseEntity.ok("User registered successfully");
    }

    // TODO: Добавить здесь конечные точки входа и выхода, как того требует конфигурация Spring Security.
}

