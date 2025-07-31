package kg.attractor.controller;

import kg.attractor.quiz.model.Result;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
public class ResultController {

    @PostMapping
    public ResponseEntity<String> saveResult(@RequestBody Result result) {
        //TODO
        return ResponseEntity.status(HttpStatus.CREATED).body("Result saved (заглушка)");
    }

    public ResponseEntity<List<Result>> getResultsByUser(@PathVariable Long userId) {
        //TODO
        return ResponseEntity.ok(List.of());
    }

    @GetMapping("/quiz/{quizId}/leaderboard")
    public ResponseEntity<List<Result>> getLeaderboard(@PathVariable Long quizId) {
        //TODO
        return ResponseEntity.ok(List.of());
    }
}
