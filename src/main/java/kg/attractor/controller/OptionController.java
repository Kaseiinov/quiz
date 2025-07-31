package kg.attractor.controller;

import kg.attractor.quiz.dao.OptionDao;
import kg.attractor.quiz.model.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionDao optionDao;

    @PostMapping
    public ResponseEntity<String> createOption(@RequestBody Option option) {
        optionDao.createOption(option);
        return ResponseEntity.status(HttpStatus.CREATED).body("Option created successfully");
    }
}