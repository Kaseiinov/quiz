package kg.attractor.quiz.dao.mapper;

import kg.attractor.quiz.model.Option;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionMapper implements RowMapper<Option> {

    @Override
    public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
        return Option.builder()
                .id(rs.getLong("id"))
                .option(rs.getString("option_text"))
                .isCorrect(rs.getBoolean("is_correct"))
                .questionId(rs.getLong("question_id"))
                .build();
    }
}