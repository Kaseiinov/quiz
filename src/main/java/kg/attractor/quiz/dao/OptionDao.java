package kg.attractor.quiz.dao;

import kg.attractor.quiz.mapper.OptionMapper;
import kg.attractor.quiz.model.Option;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OptionDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public void createOption(Option option) {
        String sql = "insert into options (question_id, option_text, is_correct) values " +
                " (:questionId, :optionText, :isCorrect);";

        namedParameter.update(sql,
                new MapSqlParameterSource()
                        .addValue("questionId", option.getQuestionId())
                        .addValue("optionText", option.getOption())
                        .addValue("isCorrect", option.getIsCorrect())
        );
    }
}
