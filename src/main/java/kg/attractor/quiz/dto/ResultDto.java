package kg.attractor.quiz.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResultDto {

    private Integer countQuestions;
    private List<QuestionOptionDto> questionOptionDtos;
    private Integer countCorrectOptions;
    private Integer options;

}
