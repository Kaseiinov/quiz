package kg.attractor.quiz.model;


import jakarta.validation.constraints.NotNull;
import kg.attractor.quiz.dto.OptionDto;
import kg.attractor.quiz.dto.QuestionDto;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Data
@Builder
@Getter
@Setter
public class Quiz {
    private Long id;
    private String title;
    private String description;
    private Long creatorId;

    private List<QuestionDto> questions;

    private List<OptionDto> options;
}
