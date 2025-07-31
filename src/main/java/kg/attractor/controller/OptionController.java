package kg.attractor.controller;

import kg.attractor.quiz.dto.OptionDto;
import kg.attractor.quiz.service.OptionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/options")
@RequiredArgsConstructor
public class OptionController {

    private final OptionService optionService;

    @PostMapping("/{questionId}")
    public ResponseEntity<Void> createOption(@PathVariable Long questionId,
                                             @RequestBody @Validated OptionDto optionDto) {
        optionService.createOption(questionId, optionDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{questionId}")
    public ResponseEntity<List<OptionDto>> getOptionsByQuestionId(@PathVariable Long questionId) {
        return ResponseEntity.ok(optionService.getOptionsByQuestionId(questionId));
    }
}