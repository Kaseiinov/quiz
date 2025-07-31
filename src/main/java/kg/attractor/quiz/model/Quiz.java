package kg.attractor.quiz.model;


import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class Quiz {
    private Long id;
    private String title;
    private String description;
    private Long creatorId;
    private Question question;
    private List<Option> options;
}
