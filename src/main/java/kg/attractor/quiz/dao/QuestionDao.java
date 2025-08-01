package kg.attractor.quiz.dao;

import kg.attractor.quiz.mapper.QuestionMapper;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class QuestionDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public Optional<Question> getQuestionById(Long id){
        String sql = "select * from questions where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new QuestionMapper(), id));
    }

    public List<Question> findQuestionsByQuizId(Long quizId) {
        String sql = "select * from questions where quiz_id = ?";
        return jdbcTemplate.query(sql, new QuestionMapper(), quizId);
    }

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
