package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Result {
    private long id;
    private Double score;
    private long user_id;
    private long quiz_id;
}
