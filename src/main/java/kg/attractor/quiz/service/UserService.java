package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.UserDto;

import java.util.List;

public interface UserService {
    void register(UserDto userDto);

    List<UserDto> getAllUsers();
    UserDto getUserById(Long id);
    UserDto createUser(UserDto userDto);
    UserDto updateUser(Long id, UserDto userDto);
    void deleteUser(Long id);
}