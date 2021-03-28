package br.com.letscode.java.moviesbattle.quiz.user;

import br.com.letscode.java.moviesbattle.quiz.Quiz;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository repository;

    public User findByUsername(String username) {
        return this.repository.findByUsername(username)
            .orElseThrow();
    }

    public void save(User user) {
        this.repository.save(user);
    }

}
