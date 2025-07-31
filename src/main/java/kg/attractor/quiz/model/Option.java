package kg.attractor.quiz.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.naming.ldap.PagedResultsControl;

@Data
@Builder
@Getter
@Setter
public class Option {
    private Long id;
    private String option;
    private Boolean isCorrect;
    private Long question_id;
}
