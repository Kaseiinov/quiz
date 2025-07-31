package kg.attractor.quiz.service.impl;

import kg.attractor.quiz.dao.UserDao;
import kg.attractor.quiz.dto.UserDto;
import kg.attractor.quiz.model.User;
import kg.attractor.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserDao userDao;
    private final PasswordEncoder encoder;

    @Override
    public void register(UserDto userDto) {
        User user = User.builder()
                .username(userDto.getUsername())
                .email(userDto.getEmail())
                .password(encoder.encode(userDto.getPassword()))
                .build();
        userDao.register(user);
        log.info("User {} registered", userDto.getEmail());
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userDao.getAllUsers().stream()
                .map(this::toDto)
                .toList();
    }

    @Override
    public UserDto getUserById(Long id) {
        return toDto(userDao.getUserById(id));
    }

    @Override
    public UserDto createUser(UserDto userDto) {
        User user = toEntity(userDto);
        user.setPassword(encoder.encode(userDto.getPassword()));
        Long id = userDao.createUser(user);
        user.setId(id);
        return toDto(user);
    }

    @Override
    public UserDto updateUser(Long id, UserDto userDto) {
        User user = toEntity(userDto);
        user.setId(id);
        user.setPassword(encoder.encode(userDto.getPassword()));
        userDao.updateUser(user);
        return toDto(user);
    }

    @Override
    public void deleteUser(Long id) {
        userDao.deleteUser(id);
    }

    private UserDto toDto(User user) {
        return UserDto.builder()
                .id(user.getId())
                .username(user.getUsername())
                .email(user.getEmail())
                .build();
    }

    private User toEntity(UserDto dto) {
        return User.builder()
                .id(dto.getId())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
    }
}