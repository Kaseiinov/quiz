package kg.attractor.quiz.model;

import lombok.*;

import javax.naming.ldap.PagedResultsControl;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Option {
    private Long id;
    private String option;
    private Boolean isCorrect ;
    private Long questionId;
}
