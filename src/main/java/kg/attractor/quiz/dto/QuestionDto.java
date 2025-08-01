package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class QuestionDto {
    private Long id;
    private Long quiz_id;
    @NotBlank
    private String question;

}
