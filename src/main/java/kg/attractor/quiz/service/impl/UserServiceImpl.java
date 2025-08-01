package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.UserDao;
import kg.attractor.quiz.dto.UserDto;
import kg.attractor.quiz.model.User;
import kg.attractor.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final UserDao userDao;
    private final PasswordEncoder encoder;

    @Override
    public void register(UserDto userDto) {
        User user =  User
                .builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .role_id(userDto.getRole_id())
                .build();
        userDao.register(user);
        log.info("User {} registered", userDto.getEmail());
    }

}
