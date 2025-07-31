package kg.attractor.quiz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Email
@Builder
public class ResultDto {
    @NotNull
    private Double score;
}
