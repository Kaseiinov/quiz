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
    private Long id;
    private String title;
    private String description;
    private Long creator_id;
}
