package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    @NotBlank
    private String question;

    @NotNull
    private Long quizId;
}
