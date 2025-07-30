package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Result {
    private int id;
    private int score;
    private int user_id;
    private int quiz_id;
}
