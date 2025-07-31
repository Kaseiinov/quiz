package kg.attractor.quiz.model;

import jdk.jfr.Enabled;

import lombok.*;

@Data
@Builder
@Getter
@Setter

@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Long id;
    private String username;
    private String email;
    private String password;

}
