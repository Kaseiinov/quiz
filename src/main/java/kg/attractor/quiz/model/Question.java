package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Setter
@Getter
public class Question {
    private int id;
    private String question;
    private int quiz_id;
}
