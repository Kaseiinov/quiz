package kg.attractor.quiz.mapper;

import kg.attractor.quiz.dto.ResultDto;
import kg.attractor.quiz.model.Quiz;
import kg.attractor.quiz.model.Result;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;

@Component
@RequiredArgsConstructor
public class ResultMapper implements RowMapper<Result> {
    @Override
    public Result mapRow(ResultSet rs, int rowNum) throws SQLException {
        Result result = new Result();
        result.setQuizId(rs.getLong("quiz_id"));
        result.setUserId(rs.getLong("user_id"));
        result.setScore(rs.getDouble("score"));
        result.setId(rs.getLong("id"));
        return result;
    }
}
