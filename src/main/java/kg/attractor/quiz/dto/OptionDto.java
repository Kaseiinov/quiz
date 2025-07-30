package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class OptionDto {
    @NotBlank
    private String option;

    private boolean is_correct;
}
