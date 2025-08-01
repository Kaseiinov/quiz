package kg.attractor.quiz.service;

import kg.attractor.quiz.dto.StatisticsDto;
import kg.attractor.quiz.dto.UserDto;

public interface UserService {
    StatisticsDto getUserStatistics(long userId);

    void register(UserDto userDto);

}
