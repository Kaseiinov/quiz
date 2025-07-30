package kg.attractor.quiz.model;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class Quiz {
    private int id;
    private String title;
    private String description;
    private int creator_id;
}
