package kg.attractor.quiz.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Result {
    private Long id;
    private Double score;
    private Long userId;
    private Long quizId;
}
