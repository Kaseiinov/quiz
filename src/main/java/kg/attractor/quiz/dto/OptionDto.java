package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDto {
    private Long question_id;

    @NotBlank
    private String option;

    private Boolean isCorrect;
}
