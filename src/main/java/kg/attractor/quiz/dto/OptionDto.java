package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDto {
    private Long id;
    private Long question_id;

    @NotBlank
    private String option;

    @NotNull
    private Boolean isCorrect;
}
