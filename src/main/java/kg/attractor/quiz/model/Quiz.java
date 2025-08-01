package kg.attractor.quiz.model;


import jakarta.validation.constraints.NotNull;
import kg.attractor.quiz.dto.OptionDto;
import kg.attractor.quiz.dto.QuestionDto;
import kg.attractor.quiz.dto.QuestionOptionDto;
import lombok.*;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Quiz {
    private Long id;
    private String title;
    private String description;
    private Long creatorId;

    private Integer countOfQuestions;
}
