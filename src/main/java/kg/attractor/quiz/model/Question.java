package kg.attractor.quiz.model;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Question {
    private Long id;
    private String question;
    private Long quizId;
}
