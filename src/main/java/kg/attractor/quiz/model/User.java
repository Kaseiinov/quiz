package kg.attractor.quiz.model;

import jdk.jfr.Enabled;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Builder
@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String email;
    private String password;

}
