package kg.attractor.quiz.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Max;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class RatingDto {
    @Min(1)
    @Max(5)
    private int rating;
}
