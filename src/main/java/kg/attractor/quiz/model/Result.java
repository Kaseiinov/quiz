package kg.attractor.quiz.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Result {
    private Long id;
    private Double score;
    private Long userId;
    private Long quizId;
}
