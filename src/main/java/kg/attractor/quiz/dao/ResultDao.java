package kg.attractor.quiz.dao;

import kg.attractor.quiz.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Component
@RequiredArgsConstructor
public class ResultDao {

    private final JdbcTemplate jdbcTemplate;

    public void saveResult(Result result) {
        String sql = "INSERT INTO results (score, user_id, quiz_id) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, result.getScore(), result.getUserId(), result.getQuizId());
    }

    public List<Result> getResultsByQuizId(Long quizId) {
        String sql = "SELECT * FROM results WHERE quiz_id = ?";
        return jdbcTemplate.query(sql, new Object[]{quizId}, new ResultRowMapper());
    }

    private static class ResultRowMapper implements RowMapper<Result> {
        @Override
        public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
            return Result.builder()
                    .id(rs.getLong("id"))
                    .score(rs.getDouble("score"))
                    .userId(rs.getLong("user_id"))
                    .quizId(rs.getLong("quiz_id"))
                    .build();
        }
    }
}