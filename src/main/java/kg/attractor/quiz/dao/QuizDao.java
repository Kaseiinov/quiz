package kg.attractor.quiz.dao;

import kg.attractor.quiz.mapper.QuizMapper;
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

@Component
@RequiredArgsConstructor
public class QuizDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public Integer getCountOfQuestions(Long id) {
        String sql = "select count(*) \n" +
                "from quizzes q\n" +
                "join QUESTIONS qe on q.ID = qe.QUIZ_ID\n" +
                "where q.ID = ?;";
        return jdbcTemplate.queryForObject(sql, Integer.class, id);
    }

    public List<Quiz> findQuizzes(){
        String sql = "select * from quizzes";
        return jdbcTemplate.query(sql, new QuizMapper());
    }

    public Long createQuiz(Quiz quiz) {
        String sql = "insert into quizzes(title, description, creator_id) " +
                "values(:title, :description, :creatorId);";

        MapSqlParameterSource parameters = new MapSqlParameterSource()
                .addValue("title", quiz.getTitle())
                .addValue("description", quiz.getDescription())
                .addValue("creatorId", quiz.getCreatorId());


        KeyHolder keyHolder = new GeneratedKeyHolder();
        namedParameter.update(sql, parameters, keyHolder);
        return Objects.requireNonNull(keyHolder.getKey()).longValue();
    }
}
