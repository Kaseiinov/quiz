package kg.attractor.quiz.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class StatisticsDto {
    private int totalQuizzesTaken;
    private double averageScore;
    private int totalCorrectAnswers;
    private int totalQuestionAnswered;
}
