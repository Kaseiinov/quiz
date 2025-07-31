package kg.attractor.controller;

import kg.attractor.quiz.dto.ResultDto;
import kg.attractor.quiz.service.ResultService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/results")
@RequiredArgsConstructor
public class ResultController {

    private final ResultService resultService;

    @PostMapping
    public ResponseEntity<Void> saveResult(@RequestBody ResultDto dto) {
        resultService.saveResult(dto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/quiz/{quizId}")
    public ResponseEntity<List<ResultDto>> getResultsByQuizId(@PathVariable Long quizId) {
        return ResponseEntity.ok(resultService.getResultsByQuizId(quizId));
    }
}