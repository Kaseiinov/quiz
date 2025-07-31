package kg.attractor.quiz.mapper;

import kg.attractor.quiz.dto.QuizDto;
import kg.attractor.quiz.model.Quiz;
import kg.attractor.quiz.model.User;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class QuizMapper implements RowMapper<Quiz> {
    @Override
    public Quiz mapRow(ResultSet rs, int rowNum) throws SQLException {
        Quiz quiz = new Quiz();
        quiz.setId(rs.getLong("id"));
        quiz.setTitle(rs.getString("title"));
        quiz.setDescription(rs.getString("description"));
        quiz.setCreatorId(rs.getLong("creator_id"));
        return quiz;
    }
}
