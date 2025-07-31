package kg.attractor.quiz.dao;

import kg.attractor.quiz.model.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class QuizDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public Long createQuiz(Quiz quiz) {
        String sql = "INSERT INTO quizzes (title, description, creator_id) " +
                "VALUES (:title, :description, :creatorId);";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", quiz.getTitle())
                .addValue("description", quiz.getDescription())
                .addValue("creatorId", quiz.getCreatorId());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameter.update(sql, parameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public List<Quiz> getAllQuizzes() {
        String sql = "SELECT * FROM quizzes";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Quiz.class));
    }

    public Quiz getQuizById(Long id) {
        String sql = "SELECT * FROM quizzes WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Quiz.class), id);
    }

    public void deleteQuiz(Long id) {
        String sql = "DELETE FROM quizzes WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}