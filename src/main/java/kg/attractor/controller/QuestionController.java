package kg.attractor.controller;

import kg.attractor.quiz.dao.QuestionDao;
import kg.attractor.quiz.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/questions")
@RequiredArgsConstructor
public class QuestionController {

    private final QuestionDao questionDao;

    @PostMapping
    public ResponseEntity<Long> createQuestion(@RequestBody Question question) {
        Long questionId = questionDao.createQuestion(question);
        return ResponseEntity.ok(questionId);
    }
}