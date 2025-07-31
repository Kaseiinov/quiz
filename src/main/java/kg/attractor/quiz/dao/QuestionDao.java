package kg.attractor.quiz.dao;

import kg.attractor.quiz.model.Question;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Objects;

@Component
@RequiredArgsConstructor
public class QuestionDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    private final RowMapper<Question> rowMapper = (rs, rowNum) -> Question.builder()
            .id(rs.getLong("id"))
            .quizId(rs.getLong("quiz_id"))
            .question(rs.getString("question_text"))
            .build();

    public Long createQuestion(Question question) {
        String sql = "INSERT INTO questions (quiz_id, question_text) VALUES (:quizId, :questionText)";
        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("quizId", question.getQuizId())
                .addValue("questionText", question.getQuestion());

        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameter.update(sql, parameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }

    public List<Question> getAllQuestions() {
        String sql = "SELECT * FROM QUESTIONS";
        return jdbcTemplate.query(sql, (rs, rowNum) -> Question.builder()
                .id(rs.getLong("id"))
                .question(rs.getString("question_text"))
                .quizId(rs.getLong("quiz_id"))
                .build());
    }

    public List<Question> getQuestionsByQuizId(Long quizId) {
        String sql = "SELECT * FROM QUESTIONS WHERE quiz_id = ?";
        return jdbcTemplate.query(sql, new Object[]{quizId}, (rs, rowNum) -> Question.builder()
                .id(rs.getLong("id"))
                .question(rs.getString("question_text"))
                .quizId(rs.getLong("quiz_id"))
                .build());
    }

    public Question getQuestionById(Long id) {
        String sql = "SELECT * FROM QUESTIONS WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> Question.builder()
                .id(rs.getLong("id"))
                .question(rs.getString("question_text"))
                .quizId(rs.getLong("quiz_id"))
                .build());
    }

    public void updateQuestion(Question question) {
        String sql = "UPDATE QUESTIONS SET question_text = ? WHERE id = ?";
        jdbcTemplate.update(sql, question.getQuestion(), question.getId());
    }

    public void deleteQuestion(Long id) {
        String sql = "DELETE FROM QUESTIONS WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}