package kg.attractor.quiz.mapper;

import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.model.Question;
import kg.attractor.quiz.model.Quiz;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class OptionMapper implements RowMapper<Option> {
    @Override
    public Option mapRow(ResultSet rs, int rowNum) throws SQLException {
        Option option = new Option();
        option.setQuestionId(rs.getLong("question_id"));
        option.setOption(rs.getString("option_text"));
        option.setIsCorrect(rs.getBoolean("is_correct"));
        return option;
    }
}
