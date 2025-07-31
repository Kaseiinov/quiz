package kg.attractor.quiz.dao;

import kg.attractor.quiz.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public void register(User user) {
        String sql = "insert into users (username, email, password) " +
                "values (:username, :email, :password)";

        namedParameter.update(sql,
                new MapSqlParameterSource()
                        .addValue("username", user.getUsername())
                        .addValue("email", user.getEmail())
                        .addValue("password", user.getPassword())
        );
    }
}
