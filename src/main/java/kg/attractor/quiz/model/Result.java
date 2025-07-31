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
    private long id;
    private Double score;
    private long user_id;
    private long quiz_id;
}
