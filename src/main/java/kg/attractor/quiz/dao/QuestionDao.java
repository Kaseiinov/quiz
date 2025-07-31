package kg.attractor.quiz.dao;

import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
@RequiredArgsConstructor
public class QuestionDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public Long createQuestion(Question question) {
        String sql = "insert into QUESTIONS(quiz_id, question_text) " +
                "values(:quizId, :questionText);";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("quizId", question.getQuizId())
                .addValue("questionText", question.getQuestion());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameter.update(sql, parameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }
}
