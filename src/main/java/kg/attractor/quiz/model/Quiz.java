package kg.attractor.quiz.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class Quiz {
    private long id;
    private String title;
    private String description;
    private long creator_id;
}
