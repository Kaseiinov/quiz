package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Question {
    private long id;
    private String question;
    private long quiz_id;
}
