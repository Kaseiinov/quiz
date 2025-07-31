package kg.attractor.quiz.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class User {
    private long id;
    private String username;
    private String email;
    private String password;

}
