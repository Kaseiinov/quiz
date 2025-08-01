package kg.attractor.quiz.controller;

// import kg.attractor.quiz.dto.UserStatisticsDto;
import kg.attractor.quiz.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

//    @GetMapping("/{userId}/statistics")
//    public ResponseEntity<UserStatisticsDto> getUserStatistics(@PathVariable Long userId) {
//        // TODO: Реализовать логику в UserService для получения статистики
//        UserStatisticsDto stats = userService.getUserStatistics(userId);
//        return ResponseEntity.ok(stats);
//    }
}