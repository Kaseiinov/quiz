package kg.attractor.quiz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AnswerDto {
    @NotNull
    private long questionId;

    @NotNull
    private long selectedOptionId;
}
