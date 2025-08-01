package kg.attractor.quiz.dao;

import kg.attractor.quiz.mapper.UserMapper;
import kg.attractor.quiz.model.User;
import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class UserDao {
    private final JdbcTemplate jdbcTemplate;
    private final NamedParameterJdbcTemplate namedParameter;

    public Optional<User> findById(Long id) {
        String sql = "select * from users where id = ?";
        return Optional.ofNullable(jdbcTemplate.queryForObject(sql, new UserMapper(), id));
    }

    public void register(User user) {
        String sql = "insert into users (username, email, password, ENABLED, role_id) " +
                "values (:username, :email, :password, :enabled, :roleId)";

        namedParameter.update(sql,
                new MapSqlParameterSource()
                        .addValue("username", user.getUsername())
                        .addValue("email", user.getEmail())
                        .addValue("password", user.getPassword())
                        .addValue("roleId", user.getRole_id())
                        .addValue("enabled", true)
        );
    }
}
