package kg.attractor.quiz.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Quiz {
    private long id;
    private String title;
    private String description;
    private long creator_id;
}
