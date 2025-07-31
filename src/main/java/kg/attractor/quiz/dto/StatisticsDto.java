package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsDto {
    @NotNull
    private Integer totalQuizzesTaken;

    @NotNull
    private Double averageScore;

    @NotNull
    private Integer totalCorrectAnswers;

    @NotNull
    private Integer totalQuestionAnswered;
}
