package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ResultDto {
    @NotNull
    private Double score;

    @NotNull
    private Long userId;

    @NotNull
    private Long quizId;
}