package kg.attractor.quiz.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Setter
@Getter
public class Question {
    private long id;
    private String question;
    private long quiz_id;
}
