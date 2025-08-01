package kg.attractor.quiz.mapper;

import kg.attractor.quiz.model.Option;
import kg.attractor.quiz.model.Question;
import org.springframework.jdbc.core.RowMapper;

import javax.swing.tree.TreePath;
import java.sql.ResultSet;
import java.sql.SQLException;

public class QuestionMapper implements RowMapper<Question> {
    @Override
    public Question mapRow(ResultSet rs, int rowNum) throws SQLException {
        Question question = new Question();
        question.setId(rs.getLong("id"));
        question.setQuestion(rs.getString("question_text"));
        question.setQuizId(rs.getLong("quiz_id"));
        return question;
    }

}
