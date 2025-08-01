package kg.attractor.quiz.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class QuizDto {
    private Long id;
    @NotBlank
    private String title;
    @NotBlank
    private String description;
    @NotNull
    private Long creatorId;

    @NotNull
    private List<QuestionOptionDto> questionOptions;

    private Integer countOfQuestions;
}
