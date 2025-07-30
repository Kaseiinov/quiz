package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.naming.ldap.PagedResultsControl;

@Data
@Getter
@Setter
public class Option {
    private int id;
    private String option;
    private boolean is_correct;
    private int question_id;


}
