package br.com.letscode.java.moviesbattle.quiz.competition;

import br.com.letscode.java.moviesbattle.quiz.user.User;
import br.com.letscode.java.moviesbattle.quiz.user.UserService;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserQuizService {

    private final UserQuizRepository repository;
    private final UserService userService;

    private User getUser(String username) {
        return this.userService.findByUsername(username);
    }

    public void save(UserQuiz userQuiz) {
        this.repository.save(userQuiz);
    }

    private UserQuiz findByUsernameAndQuizId(String username, UUID quizId) {
        return this.repository.findByUserAndQuizId(this.getUser(username), quizId);
    }

}
